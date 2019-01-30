package linkedlist;

public class LinkedListPivoting {
    Node head = null;

    public static void main(String[] args) {
        LinkedListPivoting list = new LinkedListPivoting();

        list.head = new Node(3);
        list.head.next = new Node(5);
        list.head.next.next = new Node(8);
        list.head.next.next.next = new Node(5);
        list.head.next.next.next.next = new Node(10);
        list.head.next.next.next.next.next = new Node(2);
        list.head.next.next.next.next.next.next = new Node(1);

        Node newHead = list.partition(list.head, 5);
        new ReverseLinkedList().print(newHead);
    }

    private Node partition(Node head, int x) {
        if (head == null || head.next == null) return null;

        Node head1 = new Node(0);
        Node lessThan = head1;

        Node head2 = new Node(0);
        Node greaterThan = head2;

        Node p = head;

        while (p != null) {
            if (p.data < x) {
                lessThan.next = p;
                lessThan = lessThan.next;
            } else {
                greaterThan.next = p;
                greaterThan = greaterThan.next;
            }
            p = p.next;
        }

        lessThan.next = head2.next;
        greaterThan.next = null;
        return head1.next;
    }
}
