package trees;

import java.util.LinkedList;
import java.util.Queue;

/*
* Find the sum of all left leaves in a given binary trees.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary trees, with values 9 and 15 respectively. Return 24.
*/
public class SumOfLeftLeaves {
    Node root = null;

    public static void main(String[] args) {
        SumOfLeftLeaves tree = new SumOfLeftLeaves();
        tree.root = new Node(3);
        tree.root.left = new Node(9);
        tree.root.right = new Node(20);
        tree.root.right.left = new Node(15);
        tree.root.right.right = new Node(7);

        System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(tree.root));
    }

    private int sumOfLeftLeaves(Node root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int sum = 0;
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.left != null) {
                queue.add(current.left);
                if (current.left.left == null && current.left.right == null) sum += current.left.data;
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return sum;
    }
}
