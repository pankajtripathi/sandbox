package trees;

import java.util.Stack;

public class RangeSumBST {
    private int sum = 0;

    public int rangeSumBST(Node root, int low, int high) {
        dfs(root, low, high);
        return sum;
    }

    public void dfs(Node root, int low, int high) {
        if (root != null) {
            if (low <= root.data && root.data <= high) sum += root.data;
            if (low < root.data) dfs(root.left, low, high);
            if (high > root.data) dfs(root.right, low, high);
        }
    }

    public int rangeSumIterative(Node root, int low, int high) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        int res = 0;
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (low <= current.data && current.data <= high) res += current.data;
            if (low < current.data) stack.push(current.left);
            if (high > current.data) stack.push(current.right);
        }
        return res;
    }
}
