package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {
    Node root = null;
    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree tree = new SerializeAndDeserializeBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(5);

        String treeStruct = new SerializeAndDeserializeBinaryTree().serialize(tree.root);
        System.out.println(treeStruct);

        System.out.println(new BinaryTreeBFSWithQueue().bfs(new SerializeAndDeserializeBinaryTree().deserialize(treeStruct)));
    }

    public String serialize(Node root) {
        return preOrder(root, "");
    }

    private String preOrder(Node root, String res) {
        if (root == null) {
            res += "null,";
        } else {
            res += String.valueOf(root.data) + ",";
            res = preOrder(root.left, res);
            res = preOrder(root.right, res);
        }
        return res;
    }

    public Node deserialize(String data) {
        String[] entries = data.split(",");
        List<String> tree = new ArrayList<>(Arrays.asList(entries));
        return recreate(tree);
    }

    private Node recreate(List<String> tree) {
        if (tree.get(0).equals("null")) {
            tree.remove(0);
            return null;
        }

        Node root = new Node(Integer.parseInt(tree.get(0)));
        tree.remove(0);

        root.left = recreate(tree);
        root.right = recreate(tree);

        return root;
    }
}
