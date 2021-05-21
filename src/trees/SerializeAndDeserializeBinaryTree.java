package trees;

import java.util.*;

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
        return preOrder(root, new StringBuilder()).toString();
    }

    private StringBuilder preOrder(Node root, StringBuilder res) {
        if (root == null) {
            res.append("null,");
        } else {
            res.append(String.valueOf(root.data)).append(",");
            res = preOrder(root.left, res);
            res = preOrder(root.right, res);
        }
        return res;
    }

    public Node deserialize(String data) {
        Queue<String> nodes = new ArrayDeque<>();
        for (String node : data.split(",")) {
            nodes.add(node);
        }
        return recreate(nodes);
    }

    private Node recreate(Queue<String> nodes) {
        String node = nodes.poll();
        if (node.equals("null")) {
            return null;
        }

        Node root = new Node(Integer.parseInt(node));
        root.left = recreate(nodes);
        root.right = recreate(nodes);

        return root;
    }
}
