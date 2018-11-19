package trees;

/*
*
Given a binary trees, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary trees [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
* */
public class SymmetricTree {
    Node root = null;

    public static void main(String[] args) {
        SymmetricTree tree = new SymmetricTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(3);

        System.out.println(new SymmetricTree().isSymmetric(tree.root));
    }

    private boolean isSymmetric(Node root) {
        if (root == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(Node p, Node q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.data != q.data) return false;
        if (!isSymmetricHelper(p.left, q.right)) return false;
        if (!isSymmetricHelper(p.right, q.left)) return false;
        return true;
    }
}
