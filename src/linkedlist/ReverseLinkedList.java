package linkedlist;

public class ReverseLinkedList {
    Node head = null;

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);

        System.out.println("List before reversing: ");
        list.print(list.head);

        System.out.println("List reversed: ");
        list.reverseList(list.head);
        list.print(list.head);
    }

    private void reverseList(Node head) {
        if (head == null || head.next == null) return;
        Node p = head;
        Node q = p.next;
        head.next = null;

        while (p != null && q != null) {
            Node temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }

        this.head = p;
    }

    public void print(Node head) {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }
}
