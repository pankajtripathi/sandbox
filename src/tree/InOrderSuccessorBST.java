package tree;

/*
*
* Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.

Example 1:

Input: root = [2,1,3], p = 1

  2
 / \
1   3

Output: 2
*
* */

public class InOrderSuccessorBST {
    Node root = null;
    public static void main(String[] args) {
        InOrderSuccessorBST tree = new InOrderSuccessorBST();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);

        // in order successor of 8
        System.out.print("In Order Successor of " + tree.root.left.data);
        System.out.println(" => " + tree.inorderSuccessor(tree.root, tree.root.left).data);

        // Output:
        // In Order Successor of 8 => 10
    }

    private Node inorderSuccessor(Node root, Node p) {
        if (root == null) return null;

        if (p.right != null) {
            return minValue(p.right);
        }

        Node temp = root;
        Node succ = null;

        while (temp != null) {
            if (temp.data > p.data) {
                succ = temp;
                temp = temp.left;
            } else if (temp.data < p.data) {
                temp = temp.right;
            } else break;
        }

        return succ;
    }

    private Node minValue(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
