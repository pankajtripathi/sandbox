package arrays;

public class MaximumProductSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 1};
        System.out.println(new MaximumProductSubArray().maxProduct(nums));
    }

    private int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int productSoFar = nums[0];
        int maxProduct = nums[0];
        int minProduct = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // if number is negative then multiplying it with max will make product smaller and
            // for min the product will be bigger
            if (nums[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);

            productSoFar = Math.max(productSoFar, maxProduct);
        }

        return productSoFar;
    }
}
