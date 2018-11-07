package tree;

public class MinimumDepth {
    Node root = null;

    public static void main(String[] args) {
        MinimumDepth tree = new MinimumDepth();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left=new Node(4);
        tree.root.left.right=new Node(5);

        System.out.println("Minimum Depth: ");
        System.out.println(tree.minimumDepth(tree.root));
    }

    private int minimumDepth(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return 1 + minimumDepth(root.right);
        if (root.right == null) return 1 + minimumDepth(root.left);

        return 1 + Math.min(minimumDepth(root.left), minimumDepth(root.right));
    }
}
