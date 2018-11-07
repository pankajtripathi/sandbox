package tree;

public class SameTree {
    Node root = null;

    public static void main(String[] args) {
        SameTree tree1 = new SameTree();
        tree1.root = new Node(1);
        tree1.root.left = new Node(2);
        tree1.root.right = new Node(3);
        tree1.root.left.left=new Node(4);
        tree1.root.left.right=new Node(5);

        SameTree tree2 = new SameTree();
        tree2.root = new Node(1);
        tree2.root.left = new Node(2);
        tree2.root.right = new Node(3);
        tree2.root.left.left=new Node(4);
//        tree2.root.left.right=new Node(5);

        System.out.println("Both trees are same: " + tree1.isSameTree(tree1.root, tree2.root));
    }

    private boolean isSameTree(Node p, Node q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.data == q.data) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}
