package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderUsingStack {
    Node root = null;

    public static void main(String[] args) {
        PostOrderUsingStack tree = new PostOrderUsingStack();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left=new Node(4);
        tree.root.left.right=new Node(5);

        System.out.println("Binary tree DFS with Stack: ");
        System.out.println(tree.postOrder(tree.root));
    }

    private List<Integer> postOrder(Node root) {
        if (root == null) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            Node current = stack.peek();
            if (current.left == null && current.right == null) {
                result.add(current.data);
                stack.pop();
            } else {
                if (current.right != null) {
                    stack.push(current.right);
                    current.right = null;
                }

                if (current.left != null) {
                    stack.push(current.left);
                    current.left = null;
                }
            }
        }

        return result;
    }
}
