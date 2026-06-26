package hashmap_doubly_linked_list;

import java.util.HashMap;

public class LRUCache {

    /*
      Platform : LeetCode
      Question : LRU Cache (LC 146)

      Pattern  : HashMap + Doubly Linked List

      Approach :
      Cache Design

      Idea :
      - HashMap provides O(1) access to nodes using keys.
      - Doubly Linked List maintains the order of recently used nodes.
      - The Most Recently Used (MRU) node is kept near the tail.
      - The Least Recently Used (LRU) node is kept near the head.
      - Whenever a node is accessed or updated:
            Remove it from its current position.
            Insert it before the tail.
      - If cache becomes full:
            Remove the node after head (LRU node).

      Time Complexity :
      get()  -> O(1)
      put()  -> O(1)

      Space Complexity :
      O(capacity)
    */

    class Node {

        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;

    private HashMap<Integer, Node> map;

    private Node head;
    private Node tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    // Remove a node from DLL
    private void remove(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert node before tail (Most Recently Used)
    private void insert(Node node) {

        node.prev = tail.prev;
        node.next = tail;

        tail.prev.next = node;
        tail.prev = node;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        remove(node);
        insert(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {

            Node node = map.get(key);

            node.value = value;

            remove(node);
            insert(node);

        } else {

            if (map.size() == capacity) {

                Node lru = head.next;

                remove(lru);

                map.remove(lru.key);
            }

            Node newNode = new Node(key, value);

            insert(newNode);

            map.put(key, newNode);
        }
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        cache.put(1, 10);
        cache.put(2, 20);

        System.out.println(cache.get(1)); // 10

        cache.put(3, 30); // Removes key 2

        System.out.println(cache.get(2)); // -1

        cache.put(4, 40); // Removes key 1

        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 30
        System.out.println(cache.get(4)); // 40
    }
}