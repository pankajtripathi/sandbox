package tree;

public class ValidateBST {
    Node root = null;

    public static void main(String[] args) {
        ValidateBST tree1 = new ValidateBST();
        tree1.root = new Node(3);
        tree1.root.left = new Node(1);
        tree1.root.right = new Node(4);
        System.out.println("BST is valid: " +
                tree1.isValidBST(tree1.root,
                Double.NEGATIVE_INFINITY,
                Double.POSITIVE_INFINITY));

        ValidateBST tree2 = new ValidateBST();
        tree2.root = new Node(3);
        tree2.root.left = new Node(1);
        tree2.root.right = new Node(2);
        System.out.println("BST is valid: " +
                tree2.isValidBST(tree2.root,
                        Double.NEGATIVE_INFINITY,
                        Double.POSITIVE_INFINITY));
    }

    private boolean isValidBST(Node root, double min, double max) {
        if (root == null) return true;
        if (root.data <= min || root.data >= max) return false;
        return isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);
    }
}
