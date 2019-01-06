package linkedlist;

/*
Given a singly linked list, group all odd nodes together followed by the even nodes.
Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
* */
public class OddEvenLinkedList {
    Node head = null;

    public static void main(String[] args) {
        OddEvenLinkedList list = new OddEvenLinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);

        Node newHead = new OddEvenLinkedList().oddEvenList(list.head);
        new ReverseLinkedList().print(newHead);
    }

    public Node oddEvenList(Node head) {
        if (head == null) return null;
        Node odd = head;
        Node even = head.next;

        Node connect = head.next;

        while (odd != null && even != null) {
            if (even.next == null) break;

            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = connect;
        return head;
    }
}
