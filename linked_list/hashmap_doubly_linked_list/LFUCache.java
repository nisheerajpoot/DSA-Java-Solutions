package hashmap_doubly_linked_list;

import java.util.HashMap;

public class LFUCache {

    /*
      Platform : LeetCode
      Question : LFU Cache (LC 460)

      Pattern  : HashMap + Doubly Linked List

      Approach :
      Frequency Based Cache Design

      Idea :
      - Maintain two HashMaps:
          1. cache
             Key -> Node

          2. freqMap
             Frequency -> Doubly Linked List

      - Every node stores:
            key
            value
            frequency

      - Whenever a node is accessed:
            Increase its frequency.
            Remove it from old frequency list.
            Insert it into new frequency list.

      - If cache becomes full:
            Remove the Least Frequently Used node.
            If multiple nodes have same frequency,
            remove the Least Recently Used node
            from that frequency list.

      Time Complexity :
      get() -> O(1)
      put() -> O(1)

      Space Complexity :
      O(capacity)
    */

    class Node {

        int key;
        int value;
        int freq;

        Node prev;
        Node next;

        Node(int key, int value) {

            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {

        Node head;
        Node tail;

        int size;

        DoublyLinkedList() {

            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        // Insert node at end (Most Recently Used)
        public void addLast(Node node) {

            node.prev = tail.prev;
            node.next = tail;

            tail.prev.next = node;
            tail.prev = node;

            size++;
        }

        // Remove any node
        public void remove(Node node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        // Remove Least Recently Used node
        public Node removeFirst() {

            if (size == 0) {
                return null;
            }

            Node node = head.next;

            remove(node);

            return node;
        }
    }

    private int capacity;

    private int minFreq;

    private HashMap<Integer, Node> cache;

    private HashMap<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {

        this.capacity = capacity;

        this.minFreq = 0;

        cache = new HashMap<>();

        freqMap = new HashMap<>();
    }

    // Increase frequency of a node
    private void updateFrequency(Node node) {

        int oldFreq = node.freq;

        DoublyLinkedList oldList = freqMap.get(oldFreq);

        oldList.remove(node);

        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;

        DoublyLinkedList newList =
                freqMap.getOrDefault(node.freq,
                        new DoublyLinkedList());

        newList.addLast(node);

        freqMap.put(node.freq, newList);
    }

    public int get(int key) {

        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);

        updateFrequency(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        if (cache.containsKey(key)) {

            Node node = cache.get(key);

            node.value = value;

            updateFrequency(node);

            return;
        }

        if (cache.size() == capacity) {

            DoublyLinkedList minList =
                    freqMap.get(minFreq);

            Node nodeToRemove = minList.removeFirst();

            cache.remove(nodeToRemove.key);
        }

        Node newNode = new Node(key, value);

        cache.put(key, newNode);

        DoublyLinkedList list =
                freqMap.getOrDefault(1,
                        new DoublyLinkedList());

        list.addLast(newNode);

        freqMap.put(1, list);

        minFreq = 1;
    }

    public static void main(String[] args) {

        LFUCache cache = new LFUCache(2);

        cache.put(1, 10);
        cache.put(2, 20);

        System.out.println(cache.get(1)); // 10

        cache.put(3, 30); // Removes key 2

        System.out.println(cache.get(2)); // -1

        System.out.println(cache.get(3)); // 30

        cache.put(4, 40); // Removes key 1

        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 30
        System.out.println(cache.get(4)); // 40
    }
}