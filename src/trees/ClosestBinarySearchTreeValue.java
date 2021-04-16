package trees;

public class ClosestBinarySearchTreeValue {
    public int closestValue(Node root, double target) {
        int closest = root.data;
        while (root != null) {
            closest = Math.abs(root.data - target) < Math.abs(closest - target) ? root.data : closest;
            root = target < root.data ? root.left : root.right;
        }
        return closest;
    }
}
