package trees;

/*
Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a
doubly-linked list. For a circular doubly linked list, the predecessor of the first element is the last element,
and the successor of the last element is the first element.

We want to do the transformation in place. After the transformation, the left pointer of the tree node should point
to its predecessor, and the right pointer should point to its successor. You should return the pointer to the smallest
element of the linked list.
* */
public class ConvertBinaryTreeToDoublyLinkedList {
    Node root;
    public static void main(String[] args) {
        ConvertBinaryTreeToDoublyLinkedList tree = new ConvertBinaryTreeToDoublyLinkedList();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        Node res = tree.treeToDoublyList(tree.root);
        while (res != null) {
            System.out.println(res.data + " ");
            res = res.right;
        }
    }

    Node first = null;
    Node last = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        helper(root);
        last.right = first;
        first.left = last;
        return first;
    }

    public void helper(Node node) {
        if (node != null) {
            helper(node.left);
            if (last != null) {
                last.right = node;
                node.left = last;
            } else {
                first = node;
            }
            last = node;
            helper(node.right);
        }
    }
}
