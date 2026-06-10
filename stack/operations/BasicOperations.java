package stack.operations;

class Operation{


    int arr[] = new int[5];
    int top = -1;

    // push operation
    void push(int data) {

        if (top == arr.length - 1) {
            System.out.println("Stack Overflow");
            return;
        }

        top++;
        arr[top] = data;

        System.out.println(data + " pushed into stack");
    }

    // pop operation
    void pop() {

        if (top == -1) {
            System.out.println("Stack Underflow");
            return;
        }

        System.out.println(arr[top] + " removed from stack");
        top--;
    }

    // top operation
    void peek() {

        if (top == -1) {
            System.out.println("Stack is Empty");
            return;
        }

        System.out.println("Top element is: " + arr[top]);
    }

    // isEmpty operation
    void isEmpty() {

        if (top == -1) {
            System.out.println("Stack is Empty");
        } else {
            System.out.println("Stack is Not Empty");
        }
    }

    // display stack
    void display() {

        if (top == -1) {
            System.out.println("Stack is Empty");
            return;
        }

        System.out.println("Stack elements are:");

        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
}

public class BasicOperations {
    public static void main(String[] args) {
        Operation st=new Operation();
        st.push(10);
        st.push(20);
        st.push(30);

        st.display();

        st.peek();

        st.pop();

        st.display();

        st.isEmpty();

    }
}
