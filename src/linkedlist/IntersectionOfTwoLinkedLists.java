package linkedlist;

public class IntersectionOfTwoLinkedLists {
    Node head = null;

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists list1 = new IntersectionOfTwoLinkedLists();
        list1.head = new Node(4);
        list1.head.next = new Node(1);
        list1.head.next.next = new Node(8);
        list1.head.next.next.next = new Node(4);
        list1.head.next.next.next.next = new Node(5);

        IntersectionOfTwoLinkedLists list2 = new IntersectionOfTwoLinkedLists();
        list2.head = new Node(5);
        list2.head.next = new Node(0);
        list2.head.next.next = new Node(1);
        list2.head.next.next.next = new Node(8);
        list2.head.next.next.next.next = new Node(4);
        list2.head.next.next.next.next.next = new Node(5);

        new IntersectionOfTwoLinkedLists().getIntersectionNode(list1.head, list2.head);
    }

    private Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) return null;
        Node p = headA;
        Node q = headB;

        while (p != q) {
            if (p == null)
                p = headB;
            p = p.next;

            if (q == null) q = headA;
            q = q.next;
        }

        return p;
    }
}
