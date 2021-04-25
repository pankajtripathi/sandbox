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

        Node loopHead = new LinkedListCycle().detectCycle(list.head);
        System.out.println(loopHead.data);
    }

    private boolean detectLoop(Node head) {
        if (head == null || head.next == null) return false;
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow == fast;
    }

    private Node detectCycle(Node head) {
        if (head == null || head.next == null) return null;
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // if it has loop then start with slow as head and then keep iterating slow until it catches up with fast.next
            if (slow == fast) {
                slow = head;
                while (slow != null) {
                    if (slow == fast) return fast;
                    slow = slow.next;
                    fast = fast.next;
                }
            }
        }

        return null; // No cycle
    }
}
