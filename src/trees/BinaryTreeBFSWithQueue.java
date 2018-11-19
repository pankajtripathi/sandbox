package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeBFSWithQueue {
    Node root = null;

    public static void main(String[] args) {
        BinaryTreeBFSWithQueue tree = new BinaryTreeBFSWithQueue();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("BFS using queue: ");
        tree.levelOrder(tree.root);

        System.out.println("BFS returning list: ");
        System.out.println(tree.bfs(tree.root));
    }

    private void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println(current.data);

            if (current.left != null || current.right != null) {
                queue.add(current.left);
                queue.add(current.right);
            }
        }
    }

    public List<List<Integer>> bfs(Node root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            List <Integer> temp = new ArrayList<>();

            for (int i = 0; i < qSize; i++) {
                Node current = queue.poll();

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);

                temp.add(current.data);
            }

            result.add(temp);
        }

        return result;
    }
}
