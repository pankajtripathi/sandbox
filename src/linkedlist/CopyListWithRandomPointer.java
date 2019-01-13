package linkedlist;

import java.util.HashMap;
import java.util.Map;

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}

/*
* https://www.byte-by-byte.com/wp-content/uploads/2016/05/random-linked-list-diagram.png
* */

public class CopyListWithRandomPointer {
    RandomListNode head = null;

    public static void main(String[] args) {
        CopyListWithRandomPointer list = new CopyListWithRandomPointer();
        list.head = new RandomListNode(1);
        list.head.next = new RandomListNode(2);
        list.head.next.next = new RandomListNode(3);
        list.head.next.next.next = new RandomListNode(4);

        list.head.random = list.head.next.next;
        list.head.next.random = list.head;
        list.head.next.next.random = list.head.next.next;
        list.head.next.next.next.random = list.head.next;

        new CopyListWithRandomPointer().display(new CopyListWithRandomPointer().copyRandomList(list.head));
    }

    private RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode node = head;

        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }

        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }

    private void display(RandomListNode head) {
        if (head == null) return;

        RandomListNode node = head;

        System.out.println("Next Links");
        while (node != null) {
            if (node.next != null) System.out.print(node.label + " -> ");
            else System.out.print(node.label);
            node = node.next;
        }

        node = head;
        System.out.println();
        System.out.println("Random Links");
        while (node != null) {
            if (node.next != null) System.out.print(node.random.label + " -> ");
            else System.out.print(node.random.label);
            node = node.next;
        }
    }
}
