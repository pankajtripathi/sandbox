package trees;

public class SubTree {
    Node root = null;

    public static void main(String[] args) {
        SubTree tree1 = new SubTree();
        tree1.root = new Node(3);
        tree1.root.left = new Node(4);
        tree1.root.right = new Node(5);
        tree1.root.left.left=new Node(1);
        tree1.root.left.right=new Node(2);

        SubTree tree2 = new SubTree();
        tree2.root = new Node(4);
        tree2.root.left = new Node(1);
        tree2.root.right = new Node(2);

        System.out.println("Tree2 is subtree of Tree1: " + tree1.isSubtree(tree1.root, tree2.root));
    }

    private boolean isSubtree(Node s, Node t) {
        if (s == null) return false;
        if (t == null) return true;

        if (new SameTree().isSameTree(s, t)) return true;

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
}
