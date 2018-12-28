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

//        new FlattenBTToLL().flattenRec(tree.root);
//        System.out.println(new BinaryTreeBFSWithQueue().bfs(tree.root));

        new FlattenBTToLL().flattenToLL(tree.root);
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

    Node pre = null;
    private void flattenRec(Node root) {
        helper(root);
    }

    private void helper(Node root) {
        if (root == null) return;
        helper(root.right); // right in rec stack
        helper(root.left); // left in rec stack
        root.left = null; // set left as null
        root.right = pre; // set right to pre
        pre = root;  // pre to root
    }

    private void flattenToLL(Node root) {
        if (root == null) return;
        Node p = root;

        while (p.left != null || p.right != null) {
            if (p.left != null) {
                Node rightChild = p.right;
                p.right = p.left;
                p.left = null;

                Node rm = p.right;
                while (rm.right != null) {
                    rm = rm.right;
                }
                rm.right = rightChild;
            }
            p = p.right;
        }
    }
}
