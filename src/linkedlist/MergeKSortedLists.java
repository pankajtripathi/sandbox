package linkedlist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
* */
public class MergeKSortedLists {
    Node head = null;
    public static void main(String[] args) {
        MergeKSortedLists list1 = new MergeKSortedLists();
        list1.head = new Node(1);
        list1.head.next = new Node(4);
        list1.head.next.next = new Node(5);

        MergeKSortedLists list2 = new MergeKSortedLists();
        list2.head = new Node(1);
        list2.head.next = new Node(3);
        list2.head.next.next = new Node(4);

        MergeKSortedLists list3 = new MergeKSortedLists();
        list3.head = new Node(2);
        list3.head.next = new Node(6);

        Node[] lists = {list1.head, list2.head, list3.head};
        Node mergedHead = new MergeKSortedLists().mergeKLists(lists);
        new ReverseLinkedList().print(mergedHead);
    }

    public Node mergeKLists(Node[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.data));

        for (Node node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        Node head = new Node(0);
        Node currentHead = head;

        while (!queue.isEmpty()) {
            currentHead.next = queue.poll();
            currentHead = currentHead.next;

            if (currentHead.next != null) {
                queue.add(currentHead.next);
            }
        }

        return head.next;
    }
}
