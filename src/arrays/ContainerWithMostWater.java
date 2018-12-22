package arrays;

/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
* */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new ContainerWithMostWater().maxArea(height));
    }

    private int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;

        int max = 0;
        while (start <= end) {
            // min tower height * (end - start) to get index diff
            max = Math.max(max, Math.min(height[start], height[end]) * (end - start));

            // increment/decrement smaller one
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return max;
    }
}
