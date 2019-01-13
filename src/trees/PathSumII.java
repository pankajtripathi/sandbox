package trees;

import java.util.ArrayList;
import java.util.List;

/*
* Similar to PathSum. Here need to print paths as well.
* */
public class PathSumII {
    Node root = null;

    public static void main(String[] args) {
        PathSumII tree = new PathSumII();
        tree.root = new Node(5);
        tree.root.left = new Node(4);
        tree.root.right = new Node(8);
        tree.root.left.left = new Node(11);
        tree.root.left.left.left = new Node(7);
        tree.root.left.left.right = new Node(2);
        tree.root.right.left = new Node(13);
        tree.root.right.right = new Node(4);
        tree.root.right.right.right = new Node(1);

        System.out.println(new PathSumII().pathSum(tree.root, 22));
        System.out.println(new PathSumII().pathSum(tree.root, 26));
    }

    private List<List<Integer>> pathSum(Node root, int sum) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        search(root, sum, new ArrayList<>(), result);
        return result;
    }

    private void search(Node root, int sum, List<Integer> path, List<List<Integer>> result) {
        if (root == null) return;
        sum -= root.data;
        path.add(root.data);

        if (sum == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        }

        if (root.left != null) {
            search(root.left, sum, path, result);
        }

        if (root.right != null) {
            search(root.right, sum, path, result);
        }

        // remove last element once sum is achieved
        path.remove(path.size() - 1);
    }
}
