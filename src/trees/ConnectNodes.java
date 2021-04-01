package trees;

public class ConnectNodes {
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
        ConnectNodes tree = new ConnectNodes();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = null;
        tree.root.right.left = null;
        tree.root.right.right = new Node(5);

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

    /* This function returns the leftmost child of nodes at the same level
       as p. This function is used to getNExt right of p's right child
       If right child of is NULL then this can also be sued for the
       left child */
    private Node getNextRight(Node p) {
        Node temp = p.nextRight;
        while (temp != null) {
            if (temp.left != null)
                return temp.left;
            else if (temp.right != null)
                return temp.right;
            temp = temp.nextRight;
        }
        return null;
    }

    private void connect(Node root) {
        Node p = root;
        p.nextRight = null;

        while (p != null) {
            Node q = p;

            while (q != null) {
                // if left is not null then set the next right nodes
                // if right is not null then next node for left child is right child else getNextRight(q)
                if (q.left != null) {
                    if (q.right != null) {
                        q.left.nextRight = q.right;
                    } else {
                        q.left.nextRight = getNextRight(q);
                    }
                }

                if (q.right != null) {
                    q.right.nextRight = getNextRight(q);
                }

                // Set nextRight for other nodes
                q = q.nextRight;
            }

            if (p.left != null)
                p = p.left;
            else if (p.right != null)
                p = p.right;
            else p = getNextRight(p);
        }
    }
}
