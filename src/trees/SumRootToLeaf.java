package trees;

/*
*   1
   / \
  2   3
Output: 25

Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
*
*/
public class SumRootToLeaf {
    Node root = null;

    public static void main(String[] args) {
        SumRootToLeaf tree = new SumRootToLeaf();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        System.out.println(new SumRootToLeaf().sumNumbers(tree.root));
    }

    private int sumNumbers(Node root) {
        if (root == null) return 0;
        return sumNumbersHelper(root, 0);
    }

    private int sumNumbersHelper(Node root, int sum) {
        if (root == null) return 0;

        sum = sum * 10 + root.data;

        if (root.left == null && root.right == null) return sum;
        int leftTreeSum = sumNumbersHelper(root.left, sum);
        int rightTreeSum = sumNumbersHelper(root.right, sum);

        return leftTreeSum + rightTreeSum;
    }
}
