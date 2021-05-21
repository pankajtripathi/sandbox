package queue;


import java.util.Stack;

class MyQueue {
    int front;

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int key) {
        if (s1.isEmpty()) front = key;
        s1.push(key);
    }

    public int pop() {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    public int peek() {
        if (s2.empty()) return front;
        return s2.peek();
    }

    public boolean isEmpty() {
        return s1.empty() && s2.empty();
    }
}

public class QueueUsingStack {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.pop();
        System.out.println("Peek: " + q.peek());
        System.out.println(q.isEmpty());
    }
}
