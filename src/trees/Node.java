package trees;

public class Node {
    Node left;
    Node right;
    Node nextRight;
    int data;

    public Node(int data) {
        this.data = data;
        right = left = null;
        nextRight = null;
    }
}
