package trees;

import java.util.Stack;

public class KthSmallestInBST {
    public int kthSmallest(Node root, int k) {
        if (root == null) return -1;
        Stack<Node> stack = new Stack<>();

        Node current = root;
        while(current != null) {
            stack.push(current);
            current = current.left;
        }

        int i = 1;
        while (!stack.empty()) {
            current = stack.pop();

            i++;
            if (i == k)
                return current.data;

            if (current != null)
                current = current.right;

            while(current != null) {
                stack.push(current);
                current = current.left;
            }
        }

        return -1;
    }
}
