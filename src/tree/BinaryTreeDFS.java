package tree;

/*
 * Complexity is O (n^2)
 * */
public class BinaryTreeDFS {
    Node root = null;

    public static void main(String[] args) {
        BinaryTreeDFS tree = new BinaryTreeDFS();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left=new Node(4);
        tree.root.left.right=new Node(5);

        System.out.println("Inorder traversal of binary tree is ");
        tree.inOrder(tree.root);

        System.out.println("Preorder traversal of binary tree is ");
        tree.preOrder(tree.root);

        System.out.println("Postorder traversal of binary tree is ");
        tree.postOrder(tree.root);
    }

    /**
     * traverse order is L-R-N
     * */
    private void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }


    /**
     * traverse order is N-L-R
     * */
    private void preOrder(Node root) {
        if (root == null) return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * traverse order is L-N-R
     * */
    private void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
}
