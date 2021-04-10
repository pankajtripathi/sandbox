package trees;

import java.util.*;

/*
* Question is similar to vertical view. Only change is when nodes are at same row level then they should be
* sorted by value. In order to achieve
* 1. Use two queues to track row and col.
* 2. Create an object to store row and data.
* 3. Object created in step 2 should be sorted by value if row is same to achieve this write comparator for Heap.
* */
public class VerticalOrderTraversalOfBinaryTree {
    Node root = null;
    public static void main(String[] args) {
        VerticalOrderTraversalOfBinaryTree tree = new VerticalOrderTraversalOfBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(7);

        System.out.println(new VerticalOrderTraversalOfBinaryTree().verticalTraversal(tree.root));
    }

    public List<List<Integer>> verticalTraversal(Node root) {
        Map<Integer, PriorityQueue<RowData>> map = new TreeMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        Queue<Integer> cols = new ArrayDeque<>();
        Queue<Integer> rows = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;
        queue.add(root);
        cols.add(0);
        rows.add(0);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int col = cols.poll();
            int row = rows.poll();

            if (map.containsKey(col)) {
                map.get(col).add(new RowData(row, current.data));
            } else {
                PriorityQueue<RowData> pq = new PriorityQueue<>((r1, r2) -> {
                    if (r1.x == r2.x) return r1.val - r2.val;
                    else return r1.x - r2.x;
                });
                pq.add(new RowData(row, current.data));
                map.put(col, pq);
            }

            if (current.left != null) {
                queue.add(current.left);
                cols.add(col - 1);
                rows.add(row + 1);
            }

            if (current.right != null) {
                queue.add(current.right);
                cols.add(col + 1);
                rows.add(row + 1);
            }
        }

        for (Integer level : map.keySet()) {
            PriorityQueue<RowData> res = map.get(level);
            List<Integer> currentRow = new ArrayList<>();
            while (!res.isEmpty()) {
                RowData data = res.poll();
                currentRow.add(data.val);
            }
            result.add(currentRow);
        }

        return result;
    }

    class RowData {
        int x;
        int val;

        RowData (int x, int val) {
            this.x = x;
            this.val = val;
        }
    }
}
