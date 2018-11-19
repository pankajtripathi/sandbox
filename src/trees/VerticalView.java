package trees;

import java.util.*;

/*
* 
* Given a binary trees, print it vertically. The following example illustrates vertical order traversal.
           1
        /    \ 
       2      3
      / \   /   \
     4   5  6   7
               
              
The output of print this trees vertically will be:
4
2
1 5 6
3
7
* */
public class VerticalView {
    Node root = null;
    public static void main(String[] args) {
        VerticalView tree = new VerticalView();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println(new VerticalView().printVerticalOrder(tree.root));
    }

    private List<List<Integer>> printVerticalOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();

        Map<Integer, List<Integer>> map = new TreeMap<>();
        queue.add(root);
        levels.add(0);

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            int level = levels.poll();

            if (map.containsKey(level)) {
                map.get(level).add(current.data);
            } else {
                List<Integer> init = new ArrayList<>();
                init.add(current.data);
                map.put(level, init);
            }

            if (current.left != null) {
                queue.add(current.left);
                levels.add(level - 1);
            }

            if (current.right != null) {
                queue.add(current.right);
                levels.add(level + 1);
            }
        }

        for (Integer levelKey : map.keySet()) {
            result.add(map.get(levelKey));
        }

        return result;
    }
}
