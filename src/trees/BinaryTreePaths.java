package trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    Node root = null;

    public static void main(String[] args) {
        BinaryTreePaths tree = new BinaryTreePaths();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left=new Node(4);
        tree.root.left.right=new Node(5);

        System.out.println("All BT paths: ");
        System.out.println(tree.getPaths(tree.root));
    }

    private List<String> getPaths(Node root) {
        if (root == null) return new ArrayList<>();
        List<String> result = new ArrayList<>();

        this.search(root, "", result);
        return result;
    }

    private void search(Node root, String path, List<String> result) {
        if (root.right == null && root.left == null) result.add(path + root.data);
        if (root.left != null) search(root.left, path + root.data + " -> ", result);
        if (root.right != null) search(root.right, path + root.data + " -> ", result);
    }

    // Output:
    // [1 -> 2 -> 4, 1 -> 2 -> 5, 1 -> 3]
}
