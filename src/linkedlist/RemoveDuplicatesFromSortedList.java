package linkedlist;

public class RemoveDuplicatesFromSortedList {
    Node head = null;

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList list = new RemoveDuplicatesFromSortedList();
        list.head = new Node(1);
        list.head.next = new Node(1);
        list.head.next.next = new Node(2);
        list.head.next.next.next = new Node(3);
        list.head.next.next.next.next = new Node(3);

        Node newHead = new RemoveDuplicatesFromSortedList().deleteDuplicates(list.head);
        new ReverseLinkedList().print(newHead);
    }

    private Node deleteDuplicates(Node head) {
        if (head == null || head.next == null) return head;
        Node p = head;
        Node prev = null;

        while (p != null) {
            if (prev != null && prev.data == p.data) {
                prev.next = p.next;
            } else {
                prev = p;
            }

            p = p.next;
        }

        return head;
    }
}
