package linkedlist;

public class RemoveNthNodeFromEnd {
    Node head = null;

    public static void main(String[] args) {
        RemoveNthNodeFromEnd list = new RemoveNthNodeFromEnd();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);

        list.head = list.deleteNth(list.head, 2);
        new ReverseLinkedList().print(list.head);
    }

    private Node deleteNth(Node head, int n) {
        if (head == null || n == 0 || head.next == null) return null;
        Node p = head;
        Node q = head;

        int len = 0;
        int size = 0;

        // find length of the list
        while (p != null) {
            len++;
            p = p.next;
        }
        size = len;

        // traverse through list and delete node nth from end
        Node prev = null;
        for (int i = 0; i < len; i++) {
            if (size - i == n) {
                if (q == head) {
                    // if head then head is next from head
                    head = head.next;
                }
                else {
                    // next of prev is next of the present node
                    prev.next = q.next;
                }
            }
            prev = q;
            q = q.next;
        }

        return head;
    }
}
