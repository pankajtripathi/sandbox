package linkedlist;

public class ReverseNodesInGroupOfK {
    Node head = null;

    public static void main(String[] args) {
        ReverseNodesInGroupOfK list = new ReverseNodesInGroupOfK();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);

        Node reversedHead1 = new ReverseNodesInGroupOfK().revereInK(list.head, 3);
        new ReverseLinkedList().print(reversedHead1);
    }

    private Node revereInKGroup(Node head, int k) {
        if (head == null || k == 0) return head;

        int count = k;
        Node prevNode = null;
        Node nextNode = null;
        Node current = head;

        while (current != null && count > 0) {
            nextNode = current.next;
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
            count--;
        }

        if (nextNode != null) {
            head.next = revereInKGroup(nextNode, k);
        }

        return prevNode;
        // OP => 3, 2, 1, 5, 4
    }

    private Node revereInK(Node head, int k) {
        int count = 0;
        Node current = head;

        //1. test weather we have more then k node left, if less then k node left we just return head
        while (count < k) {
            if (current == null) return head;
            current = current.next;
            count++;
        }

        // 2.reverse k node at current level
        Node prevNode = revereInK(current, k); //prevNode node point to the the answer of sub-problem

        while (count > 0) {
            Node nextNode = head.next;
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
            count--;
        }

        return prevNode;
        // OP => 3, 2, 1, 4, 5
    }
}
