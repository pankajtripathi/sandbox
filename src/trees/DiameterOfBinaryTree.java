package trees;

import javax.swing.tree.TreeNode;

public class DiameterOfBinaryTree {
    int diameter = 0;
    public int diameterOfBinaryTree(Node root) {
        if (root == null) return 0;
        longestPath(root);
        return diameter;
    }

    public int longestPath(Node root) {
        if (root == null) return 0;
        int leftDiameter = longestPath(root.left);
        int rightDiameter = longestPath(root.right);

        diameter = Math.max(diameter, leftDiameter + rightDiameter);
        return Math.max(leftDiameter, rightDiameter) + 1;
    }
}
