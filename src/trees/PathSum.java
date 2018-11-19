package trees;

import java.util.LinkedList;
import java.util.Queue;

/*
* Given the below binary trees and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1

* */
public class PathSum {
    Node root = null;

    public static void main(String[] args) {
        PathSum tree = new PathSum();
        tree.root = new Node(5);
        tree.root.left = new Node(4);
        tree.root.right = new Node(8);
        tree.root.left.left = new Node(11);
        tree.root.left.left.left = new Node(7);
        tree.root.left.left.right = new Node(2);
        tree.root.right.left = new Node(13);
        tree.root.right.right = new Node(4);
        tree.root.right.right.right = new Node(1);

        System.out.println(new PathSum().hasPathSum(tree.root, 22));
        System.out.println(new PathSum().hasPathSum(tree.root, 26));
        System.out.println(new PathSum().hasPathSum(tree.root, 50));
    }

    private boolean hasPathSum(Node root, int sum) {
        if (root == null) return false;
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> values = new LinkedList<>();

        queue.add(root);
        values.add(root.data);

        while (!queue.isEmpty()) {
            int value = values.poll();
            Node current = queue.poll();

            if (value == sum && current.right == null && current.left == null) return true;

            if (current.left != null) {
                values.add(value + current.left.data);
                queue.add(current.left);
            }

            if (current.right != null) {
                values.add(value + current.right.data);
                queue.add(current.right);
            }
        }

        return false;
    }
}
