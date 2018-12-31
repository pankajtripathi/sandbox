package linkedlist;

// You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order and each of their nodes contain a single digit.
// Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
public class AddTwoNumbers {
    Node head = null;

    public static void main(String[] args) {
        AddTwoNumbers list1 = new AddTwoNumbers();
        list1.head = new Node(6);
        list1.head.next = new Node(6);
        list1.head.next.next = new Node(2);

        AddTwoNumbers list2 = new AddTwoNumbers();
        list2.head = new Node(4);
        list2.head.next = new Node(3);
        list2.head.next.next = new Node(1);

        Node newHead = new AddTwoNumbers().addTwoNumbers(list1.head, list2.head);
        new ReverseLinkedList().print(newHead.next);
    }

    public Node addTwoNumbers(Node l1, Node l2) {
        if (l1 == null || l2 == null) return null;

        Node current1 = l1;
        Node current2 = l2;

        Node head = new Node(0);
        Node currentHead = head;

        int carry = 0;
        while (current1 != null || current2 != null) {
            int sum = carry;
            if (current1 != null) {
                sum += current1.data;
                current1 = current1.next;
            }

            if (current2 != null) {
                sum += current2.data;
                current2 = current2.next;
            }

            currentHead.next = new Node(sum % 10);
            currentHead = currentHead.next;

            carry = sum / 10;
        }

        if (carry != 0) {
            currentHead.next = new Node(1);
        }
        return head;
    }
}
