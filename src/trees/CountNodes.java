package trees;

public class CountNodes {
    Node root = null;

    public static void main(String[] args) {
        CountNodes tree = new CountNodes();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Number of nodes: " + tree.count(tree.root));
    }

    private int count(Node root) {
        if (root == null) return 0;
        return 1 + count(root.left) + count(root.right);
    }
}
