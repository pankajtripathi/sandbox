package trees;

public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        Node root = new SortedArrayToBST().arrayToBST(array, 0, array.length - 1);
        System.out.println(new BinaryTreeBFSWithQueue().bfs(root));
    }

    private Node arrayToBST(int[] array, int low, int high) {
        if (low > high) return null;

        int mid = (low + high) / 2;
        Node root = new Node(array[mid]);

        root.left = arrayToBST(array, low, mid - 1);
        root.right = arrayToBST(array, mid + 1, high);

        return root;
    }
}
