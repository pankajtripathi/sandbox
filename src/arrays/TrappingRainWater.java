package arrays;

public class TrappingRainWater {
    public static void main(String[] args)
    {
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int n = arr.length;
        System.out.println("Maximum water that can be accumulated is: " + new TrappingRainWater().findWater(arr, n));

    }

    private int findWater(int[] arr, int n) {
        int leftMax = 0;
        int rightMax = 0;
        int low = 0;
        int high = n - 1;

        int result = 0;
        while (low <= high) {
            if (arr[low] < arr[high]) {
                if (arr[low] > leftMax)
                    // update max in left
                    leftMax = arr[low];
                else
                    // water on curr element =
                    // max - curr
                    result += leftMax - arr[low];

                low++;
            } else {
                if (arr[high] > rightMax)
                    // update max in right
                    rightMax = arr[high];
                else
                    // water on curr element =
                    // max - curr
                    result += rightMax - arr[high];
                high--;
            }
        }

        return result;
    }
}
