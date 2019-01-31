package queue;

public class CircularQueue {
    int[] arr;
    int front = -1;
    int rear = -1;
    int size;

    CircularQueue(int size) {
        this.size = size;
        arr = new int[size];
    }

    private void push(int key) {
        if (front == (rear + 1) % size) {
            throw new IndexOutOfBoundsException();
        }
        else {
            if (front == -1) front = rear = 0;
            else rear = (rear + 1 ) % size;

            arr[rear] = key;
        }
    }

    private int pop() {
        int val = 0;

        if (front == -1) return val;
        else {
            val = arr[front];
            if (front == rear) front = rear = -1;
            else front = (front + 1) % size;
        }

        return val;
    }

    private void display() {
        for (int i = front; i <= rear ; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.push(6);
        queue.display();

        System.out.println(queue.pop());
        queue.display();

        queue.push(7);
    }
}
