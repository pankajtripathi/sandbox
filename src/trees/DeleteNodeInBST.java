package trees;

/*
Recursively find the node that has the same value as the key, while setting the left/right nodes equal to the returned subtree
Once the node is found, have to handle the below 4 cases

node doesn't have left or right - return null

node only has left subtree- return the left subtree

node only has right subtree- return the right subtree

node has both left and right - find the minimum value in the right subtree, set that value to the currently found node,
then recursively delete the minimum value in the right subtree
*/
public class DeleteNodeInBST {
    Node root = null;

    public static void main(String[] args) {
        DeleteNodeInBST tree = new DeleteNodeInBST();
        tree.root = new Node(2);
        tree.root.left = new Node(1);
        tree.root.right = new Node(3);

        tree.deleteNode(tree.root, 3);
        System.out.println(new BinaryTreeBFSWithQueue().bfs(tree.root));
    }

    public Node deleteNode(Node root, int key) {
        if(root == null) return root;
        if(key > root.data)
            root.right = deleteNode(root.right, key);
        else if(key < root.data)
            root.left = deleteNode(root.left, key);
        else{
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            root.data = minVal(root.right);
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }

    private int minVal(Node node){
        int min = node.data;
        while(node.left != null){
            min = node.left.data;
            node = node.left;
        }
        return min;
    }
}
