package trees;

import java.util.Stack;

public class FlattenBTToLL {
    Node root = null;

    public static void main(String[] args) {
        FlattenBTToLL tree = new FlattenBTToLL();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(4);

//        new FlattenBTToLL().flatten(tree.root);
//        System.out.println(new BinaryTreeBFSWithQueue().bfs(tree.root));

        new FlattenBTToLL().flattenRec(tree.root);
        System.out.println(new BinaryTreeBFSWithQueue().bfs(tree.root));
    }

    // Go down through the left, when right is not null, push right to stack.
    private void flatten(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node p = root;

        while (p != null || !stack.empty()) {
            if (p.right != null) {
                stack.push(p.right);
            }

            if (p.left != null) {
                p.right = p.left;
                p.left = null;
            } else if (!stack.empty()) {
                p.right = stack.pop();
            }

            p = p.right;
        }
    }

    Node prev = null;
    private void flattenRec(Node root) {
        if (root == null) return;
        flattenRec(root.right);
        flattenRec(root.left);
        root.left = null;
        root.right = prev;
        prev = root;
    }
}
