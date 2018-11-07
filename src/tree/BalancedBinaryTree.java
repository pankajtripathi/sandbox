package tree;

/*
* A binary tree is balanced if difference between height of left subtree and right subtree is 1;
*
* */
public class BalancedBinaryTree {
    Node root = null;

    public static void main(String[] args) {
        BalancedBinaryTree tree = new BalancedBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left=new Node(4);
        tree.root.left.right=new Node(5);

        System.out.println(tree.isBalanced(tree.root));
    }

    private boolean isBalanced(Node root) {
        if (root == null) return true;

        // get height of left subtree and right subtree
        int lHeight = getHeight(root.left);
        int rHeight = getHeight(root.right);

        // check if diffrence is 1 or less and then keep doing the same for children nodes
        return Math.abs(lHeight - rHeight) <= 1 && isBalanced(root.right) && isBalanced(root.left);
    }

    private int getHeight(Node root) {
        if (root == null) return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
