package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightTree {
    Node root = null;

    public static void main(String[] args) {
        RightTree tree = new RightTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println(new RightTree().rightView(tree.root));
    }

    private List<Integer> rightView(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        queue.add(root);

        while(!queue.isEmpty()) {
            int qSize = queue.size();

            for (int i = 0; i < qSize; i++) {
                Node current = queue.poll();
                if (i == qSize - 1) result.add(current.data);

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }

        return result;
    }
}
