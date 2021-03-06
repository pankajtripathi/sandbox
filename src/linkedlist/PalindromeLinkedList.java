package linkedlist;

import java.util.Stack;

/*
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
*/
public class PalindromeLinkedList {
    Node head = null;
    public static void main(String[] args) {
        PalindromeLinkedList list = new PalindromeLinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
//        list.head.next.next = new Node(2);
//        list.head.next.next.next = new Node(1);

        System.out.println(new PalindromeLinkedList().isLinkedListPalindrome(list.head));
    }

    private boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;
        Stack<Integer> stack = new Stack<>();

        Node p = head;
        while (p != null) {
            stack.push(p.data);
            p = p.next;
        }

        Node q = head;
        while (q != null) {
            if (q.data != stack.pop()) return false;
            q = q.next;
        }

        return true;
    }

    private boolean isLinkedListPalindrome(Node head) {
        Node slow = head;
        Node fast = head;

        // how to find mid of a LL
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node firstHalf = head;
        Node reversedSecHalf = reverse(slow);
        new ReverseLinkedList().print(reversedSecHalf);

        while (firstHalf != null && reversedSecHalf != null) {
            if (firstHalf.data != reversedSecHalf.data) {
                return false;
            }

            firstHalf = firstHalf.next;
            reversedSecHalf = reversedSecHalf.next;
        }

        return true;
    }

    // Reverse LL
    private Node reverse(Node head) {
        Node p = head;
        Node q = p.next;
        head.next = null;

        while (p != null && q != null) {
            Node temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }

        return p;
    }
}
