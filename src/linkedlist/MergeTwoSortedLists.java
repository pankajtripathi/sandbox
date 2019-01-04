package linkedlist;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        MergeKSortedLists list1 = new MergeKSortedLists();
        list1.head = new Node(1);
        list1.head.next = new Node(2);
        list1.head.next.next = new Node(4);

        MergeKSortedLists list2 = new MergeKSortedLists();
        list2.head = new Node(1);
        list2.head.next = new Node(3);
        list2.head.next.next = new Node(4);

        Node mergedHead = new MergeTwoSortedLists().mergeTwoLists(list1.head, list2.head);
        new ReverseLinkedList().print(mergedHead);
    }

    private Node mergeTwoLists(Node l1, Node l2) {
        Node head = new Node(0);
        Node currentHead = head;


        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                currentHead.next = l1;
                l1 = l1.next;
            } else {
                currentHead.next = l2;
                l2 = l2.next;
            }
            currentHead = currentHead.next;
        }

        currentHead.next = l1 != null ? l1 : l2;
        return head.next;
    }
}
