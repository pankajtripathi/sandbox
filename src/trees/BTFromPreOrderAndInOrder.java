package trees;

public class BTFromPreOrderAndInOrder {
    public static void main(String[] args) {
        BTFromPreOrderAndInOrder obj = new BTFromPreOrderAndInOrder();
        int[] inOrder = {4, 2, 5, 1, 3};
        int[] preOrder = {1, 2, 4, 5, 3};

        Node root = obj.buildTree(inOrder, preOrder);
        System.out.println(new BinaryTreeBFSWithQueue().bfs(root));
    }

    private Node buildTree(int[] inOrder, int[] preOrder) {
        int inStart = 0;
        int inEnd = inOrder.length - 1;
        int preStart = 0;
        int preEnd = preOrder.length - 1;

        return new BTFromPreOrderAndInOrder().build(inOrder, inStart, inEnd, preOrder, preStart, preEnd);
    }

    private Node build(int[] inOrder, int inStart, int inEnd, int[] preOrder, int preStart, int preEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        int val = preOrder[preStart];
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
                preOrder,
                preStart + 1,
                preStart + startIndex - inStart);

        root.right = build(inOrder,
                startIndex + 1,
                inEnd,
                preOrder,
                preStart + startIndex - inStart + 1,
                preEnd);

        return root;
    }
}
