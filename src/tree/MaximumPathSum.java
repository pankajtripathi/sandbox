package tree;

public class MaximumPathSum {
    Node root = null;
    int globalMax = Integer.MIN_VALUE;

    public static void main(String[] args) {
        MaximumPathSum tree = new MaximumPathSum();
        tree.root = new Node(5);
        tree.root.left = new Node(4);
        tree.root.right = new Node(8);
        tree.root.left.left = new Node(11);
        tree.root.left.left.left = new Node(7);
        tree.root.left.left.right = new Node(2);
        tree.root.right.left = new Node(13);
        tree.root.right.right = new Node(4);
        tree.root.right.right.right = new Node(1);

        System.out.println(new MaximumPathSum().maxPathSum(tree.root));
    }

    private int maxPathSum(Node root) {
        calculateMax(root);
        return globalMax;
    }

    private int calculateMax(Node root) {
        if (root == null) return 0;

        int leftSubTree = calculateMax(root.left);
        int rightSubTree = calculateMax(root.right);

        // Max of current node and one of subtree plus current node
        int singleTree = Math.max(root.data, Math.max(leftSubTree, rightSubTree) + root.data);
        globalMax = Math.max(globalMax, Math.max(singleTree, leftSubTree + rightSubTree + root.data));

        return singleTree;
    }
}
