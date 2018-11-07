package tree;

public class LowestCommonAncestor {
    Node root = null;

    public static void main(String[] args) {
        LowestCommonAncestor tree = new LowestCommonAncestor();
        tree.root = new Node(5);
        tree.root.left = new Node(4);
        tree.root.right = new Node(8);
        tree.root.left.left = new Node(11);
        tree.root.left.left.left = new Node(7);
        tree.root.left.left.right = new Node(2);
        tree.root.right.left = new Node(13);
        tree.root.right.right = new Node(4);
        tree.root.right.right.right = new Node(1);

        System.out.println(new LowestCommonAncestor().lowestCommonAncestor(tree.root,
                tree.root.left.left.left,
                tree.root.left.left.right).data);
    }

    private Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null) return null;

        //root data is ancestor
        if (root == p || root == q) return root;

        Node leftAncestor = lowestCommonAncestor(root.left, p, q);
        Node rightAncestor = lowestCommonAncestor(root.right, p, q);

        // if the above values are no null then the nodes are in the left and right subtrees respectively
        if (leftAncestor == null && rightAncestor == null)
            return null;
        else if (leftAncestor != null && rightAncestor != null)
            return root;
        else
            return leftAncestor == null ? rightAncestor : leftAncestor;
    }
}
