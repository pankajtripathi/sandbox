package linkedlist;

public class LinkedListCycle {
    Node head = null;

    public static void main(String[] args) {
        LinkedListCycle list = new LinkedListCycle();
        list.head = new Node(50);
        list.head.next = new Node(20);
        list.head.next.next = new Node(15);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(10);

        // Creating a loop for testing
        list.head.next.next.next.next.next = list.head.next.next;
        System.out.println("List has a loop? "+ list.detectLoop(list.head));

    }

    private boolean detectLoop(Node head) {
        if (head == null || head.next == null) return false;
        Node slow = head;
        Node fast = head.next;

        while (fast != null && head.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow == fast;
    }
}
