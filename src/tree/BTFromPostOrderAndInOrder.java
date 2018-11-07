package tree;

public class BTFromPostOrderAndInOrder {
    public static void main(String[] args) {
        BTFromPostOrderAndInOrder obj = new BTFromPostOrderAndInOrder();
        int[] inOrder = {4, 2, 5, 1, 3};
        int[] postOrder = {4, 5, 2, 3, 1};

        Node root = obj.buildTree(inOrder, postOrder);
        System.out.println(new BinaryTreeBFSWithQueue().bfs(root));
    }

    private Node buildTree(int[] inOrder, int[] postOrder) {
        int inStart = 0;
        int inEnd = inOrder.length - 1;
        int postStart = 0;
        int postEnd = postOrder.length - 1;

        return new BTFromPostOrderAndInOrder().build(inOrder, inStart, inEnd, postOrder, postStart, postEnd);
    }

    private Node build(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd)
            return null;

        int val = postOrder[postEnd];
        Node root = new Node(val);
        int startIndex = 0;

        for (int i = 0; i < inOrder.length; i++) {
            if (val == inOrder[i]) {
                startIndex = i;
                break;
            }
        }

        root.left = build(inOrder,
                inStart,
                startIndex - 1,
                postOrder,
                postStart,
                postStart + startIndex - (inStart + 1));

        root.right = build(inOrder,
                startIndex + 1,
                inEnd,
                postOrder,
                postStart + startIndex - inStart,
                postEnd - 1);

        return root;
    }
}
