package trees;

public class InsertNodeInBST {
    Node root = null;

    public static void main(String[] args) {
        InsertNodeInBST obj = new InsertNodeInBST();
        obj.insertNode(3);
        obj.insertNode(6);
        obj.insertNode(2);

        System.out.println(new BinaryTreeBFSWithQueue().bfs(obj.root));
    }

    public void insertNode(int key) {
        root = insertNodeRec(root, key);
    }

    private Node insertNodeRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.data) {
            root.left = insertNodeRec(root.left, key);
        } else if (key > root.data) {
            root.right = insertNodeRec(root.right, key);
        }

        return root;
    }
}
