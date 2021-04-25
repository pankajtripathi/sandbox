package trees;

import java.util.*;
import java.util.stream.Collectors;

/*
* We are given a binary tree (with root node root), a target node, and an integer value K.
Return a list of the values of all nodes that have a distance K from the target node.
The answer can be returned in any order.
*
* */
public class AllNodesDistanceKInBinaryTree {
    Node root;
    public static void main(String[] args) {
        AllNodesDistanceKInBinaryTree tree = new AllNodesDistanceKInBinaryTree();
        tree.root = new Node(3);
        tree.root.left = new Node(5);
        tree.root.right = new Node(1);
        tree.root.left.left = new Node(6);
        tree.root.left.right = new Node(2);
        tree.root.right.left = new Node(0);
        tree.root.right.right = new Node(8);
        tree.root.left.right.left = new Node(7);
        tree.root.left.right.right = new Node(4);

        System.out.println(tree.distanceK(tree.root, tree.root.left, 2));
    }

    Map<Node, Node> parent = new HashMap<>();
    public List<Integer> distanceK(Node root, Node target, int K) {
        dfs(root, root);
        Queue<Node> queue = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();
        queue.add(target);
        visited.add(target);

        int dist = 0;
        while (!queue.isEmpty() && dist < K) {
            dist++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                if (current.left != null && !visited.contains(current.left)) {
                    queue.add(current.left);
                    visited.add(current.left);
                }

                if (current.right != null && !visited.contains(current.right)) {
                    queue.add(current.right);
                    visited.add(current.right);
                }

                Node par = parent.get(current);
                if (par != null && !visited.contains(par)) {
                    queue.add(par);
                    visited.add(par);
                }
            }
        }

        return queue.stream().map(p -> p.data).collect(Collectors.toList());
    }

    public void dfs(Node node, Node par) {
        if (node != null) {
            parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}
