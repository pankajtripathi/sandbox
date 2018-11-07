package stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    public static void main(String[] args) {
        MyStack st = new MyStack();
        st.push(3);
        st.push(2);
        st.push(1);
        System.out.println(st.top());
        st.pop();
        System.out.println(st.top());
        System.out.println(st.isEmpty());
    }
}

class MyStack {
    Queue<Integer> queue = new LinkedList<>();

    public void push(int data) {
        queue.add(data);
        int size = queue.size();

        while (size > 1) {
            queue.add(queue.remove());
            size--;
        }
    }

    public void pop() {
        queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int top() {
        return queue.peek();
    }
}
