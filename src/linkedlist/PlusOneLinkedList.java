package linkedlist;

public class PlusOneLinkedList {
    Node head = null;

    public static void main(String[] args) {
        PlusOneLinkedList list = new PlusOneLinkedList();
        list.head = new Node(9);
        list.head.next = new Node(9);

        Node returnedHead = list.plusOne(list.head);

        new ReverseLinkedList().print(returnedHead);
    }

    private Node plusOne(Node head) {
        if (plusOneHelper(head) == 1) {
            Node node = new Node(1);
            node.next = head;
            return node;
        }
        return head;
    }

    private int plusOneHelper(Node head) {
        if (head == null) return 1;

        int carry = plusOneHelper(head.next);

        if (carry == 0) return 0;

        int val = head.data + 1;
        head.data = val % 10;

        return val / 10;
    }
}
