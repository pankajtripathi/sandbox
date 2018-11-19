package trees;

import java.util.Stack;

public class BinaryTreeDFSWithStack {
    Node root = null;

    public static void main(String[] args) {
        BinaryTreeDFSWithStack tree = new BinaryTreeDFSWithStack();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left=new Node(4);
        tree.root.left.right=new Node(5);

        System.out.println("Binary trees DFS with Stack: ");
        tree.inOrder(tree.root);
    }

    private void inOrder(Node root) {
        if (root ==  null) return;

        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        while (stack.size() > 0) {
            current = stack.pop();
            System.out.println(current.data);

            if (current != null)
                current = current.right;

            while (current != null) {
                stack.push(current);
                current = current.left;
            }
        }
    }
}
