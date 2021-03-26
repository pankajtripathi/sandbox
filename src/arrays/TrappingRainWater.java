package arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Maximum water that can be accumulated is: " + new TrappingRainWater().trap(arr));
    }

    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int maxHeightIndex = 0;
        int maxHeight = 0;
        // Get index of the tower with max height
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxHeightIndex = i;
            }
        }

        // call helper 1. from left to maxHeightIndex 2. from right to maxHeightIndex
        return trapHelper(height, 0, maxHeightIndex, 1) +
                trapHelper(height, height.length - 1, maxHeightIndex, -1);
    }

    public int trapHelper(int[] height, int start, int end, int step) {
        int sum = 0, highestLevelSeen = Integer.MIN_VALUE;
        // Loop from start to end. If current tower is highest mark it else heighest tower minus the height of current
        for (int i = start; i != end; i+= step) {
            if (height[i] > highestLevelSeen) {
                highestLevelSeen = height[i];
            } else {
                sum += highestLevelSeen - height[i];
            }
        }

        return sum;
    }
}
