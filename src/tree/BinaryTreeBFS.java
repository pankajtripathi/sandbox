package tree;

/*
* Complexity is O (n^2)
* */
public class BinaryTreeBFS {
    Node root = null;

    public static void main(String[] args) {
        BinaryTreeBFS tree = new BinaryTreeBFS();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left=new Node(4);
        tree.root.left.right=new Node(5);

        System.out.println("Level Order traversal of binary tree is ");
        tree.levelOrder(tree.root);
    }

    // start from d = 1 that is after root node till you reach end of tree (height wise)
    private void levelOrder(Node root) {
        if (root == null) return;

        for (int d = 1; d <= height(root); d++)
            printLevelOrder(root, d);
    }

    // if on level 1 print data else move print left side and reduce level by 1 same for right side
    private void printLevelOrder(Node root, int level) {
        if (root == null) return;
        if (level == 1) System.out.println(root.data);
        else {
            printLevelOrder(root.left, level - 1);
            printLevelOrder(root.right, level - 1);
        }
    }

    private int height(Node root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
