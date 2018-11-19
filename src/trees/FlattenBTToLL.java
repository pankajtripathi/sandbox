package trees;

public class FlattenBTToLL {
    Node root = null;

    public static void main(String[] args) {
        FlattenBTToLL tree = new FlattenBTToLL();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(4);

        new FlattenBTToLL().flatten(tree.root);
        System.out.println(new BinaryTreeBFSWithQueue().bfs(tree.root));
    }

    private void flatten(Node root) {
        if (root == null) return;
        Node node = root;

        while (node.left != null || node.right != null) {
            if (node.left != null) {
                Node rightChild = node.right;

                // node node right becomes node left and left is null
                node.right = node.left;
                node.left = null;

                // Remaining left nodes .. here rightRem is node.right coz node.right has left node now
                Node rightRem = node.right;
                while (rightRem.right != null) {
                    rightRem = rightRem.right;
                }

                rightRem.right = rightChild;
            }

            node = node.right;
        }
    }
}
