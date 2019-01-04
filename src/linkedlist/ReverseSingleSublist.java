package linkedlist;

public class ReverseSingleSublist {
    Node head = null;

    public static void main(String[] args) {
        ReverseSingleSublist list = new ReverseSingleSublist();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);

        Node reversedHead1 = new ReverseSingleSublist().reverseBetween(list.head, 2, 4);
        new ReverseLinkedList().print(reversedHead1);
    }

    private Node reverseBetween(Node head, int start, int end) {
        Node dummyHead = new Node(0);
        dummyHead.next = head;
        Node prev = dummyHead;

        int count = 1;
        while (count < start) {
            prev = prev.next;
            count++;
        }

        Node current = prev.next;
        while (start < end) {
            Node nextNode = current.next;
            current.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
            start++;
        }

        return dummyHead.next;
    }
}
