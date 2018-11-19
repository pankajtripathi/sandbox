package trees;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesWithQueue {
    Node root = null;

    /* Driver program to test above functions */
    public static void main(String args[])
    {
         /* Constructed binary trees is
                 10
               /   \
             8      2
           /         \
         3            90
        */
        ConnectNodesWithQueue tree = new ConnectNodesWithQueue();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.right.right = new Node(90);

        // Populates nextRight pointer in all nodes
        tree.connect(tree.root);

        // Let us check the values of nextRight pointers
        int a = tree.root.nextRight != null ?
                tree.root.nextRight.data : -1;
        int b = tree.root.left.nextRight != null ?
                tree.root.left.nextRight.data : -1;
        int c = tree.root.right.nextRight != null ?
                tree.root.right.nextRight.data : -1;
        int d = tree.root.left.left.nextRight != null ?
                tree.root.left.left.nextRight.data : -1;
        int e = tree.root.right.right.nextRight != null ?
                tree.root.right.right.nextRight.data : -1;

        // Now lets print the values
        System.out.println("Following are populated nextRight pointers in "
                + " the trees(-1 is printed if there is no nextRight)");
        System.out.println("nextRight of " + tree.root.data + " is " + a);
        System.out.println("nextRight of " + tree.root.left.data
                + " is " + b);
        System.out.println("nextRight of " + tree.root.right.data +
                " is " + c);
        System.out.println("nextRight of " + tree.root.left.left.data +
                " is " + d);
        System.out.println("nextRight of " + tree.root.right.right.data +
                " is " + e);
    }

    private void connect(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);

        while (true) {
            Node current = queue.poll();

            if (current != null) {
                current.nextRight = queue.peek();

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            // for the last right most leaf node
            else if (!queue.isEmpty()) {
                queue.add(null);
            }
            else break;
        }
    }
}
