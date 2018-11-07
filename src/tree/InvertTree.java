package tree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {
    Node root = null;

    public static void main(String[] args) {
        InvertTree tree = new InvertTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Inverted Tree: ");
        tree.invert(tree.root);
        System.out.println(new BinaryTreeBFSWithQueue().bfs(tree.root));
    }

    private void invert(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            Node temp = current.left;
            current.left = current.right;
            current.right = temp;

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    private Node invertRec(Node root) {
        if (root == null) return root;

        Node left = invertRec(root.left);
        Node right = invertRec(root.right);

        root.left = right;
        root.right = left;
        return root;
    }
}
