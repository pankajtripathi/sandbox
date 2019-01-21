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
        list2.head.next.next.next = list1.head.next.next;

        System.out.println(new IntersectionOfTwoLinkedLists().getIntersectionNode(list1.head, list2.head).data);
        System.out.println(new IntersectionOfTwoLinkedLists().intersection(list1.head, list2.head).data);
    }

    private Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) return null;
        Node p = headA;
        Node q = headB;

        while (p != q) {
            if (p == null)
                p = headB;
            else
                p = p.next;

            if (q == null)
                q = headA;
            else
                q = q.next;
        }

        return p;
    }

    private Node intersection(Node headA, Node headB) {
        // O(m + n)
        if (headA == null || headB == null) return null;
        int lenA = len(headA);
        int lenB = len(headB);

        if (lenA > lenB) {
            headA = moveByN(headA, lenA - lenB);
        } else {
            headB = moveByN(headB, lenB - lenA);
        }

        while (headA != null && headB != null) {
            headA = headA.next;
            headB = headB.next;

            if (headA == headB) return headA;
        }

        return null;
    }

    private Node moveByN(Node node, int n) {
        while (n > 0) {
            node = node.next;
            n--;
        }
        return node;
    }

    private int len(Node node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}
