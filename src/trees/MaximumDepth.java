package trees;

public class MaximumDepth {
    Node root = null;

    public static void main(String[] args) {
        MaximumDepth tree = new MaximumDepth();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left=new Node(4);
        tree.root.left.right=new Node(5);

        System.out.println("Maximum Depth: ");
        System.out.println(tree.maximumDepth(tree.root));
    }

    private int maximumDepth(Node root) {
        if (root == null) return 0;

        int leftHeight = maximumDepth(root.left);
        int rightHeight = maximumDepth(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
