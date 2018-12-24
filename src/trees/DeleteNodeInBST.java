package trees;

public class DeleteNodeInBST {
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
