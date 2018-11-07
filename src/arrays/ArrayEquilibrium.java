package arrays;

public class ArrayEquilibrium {
    public static void main(String[] args) {
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        System.out.print("Index: " + new ArrayEquilibrium().isArrayBalanced(arr));
    }

    private int isArrayBalanced(int[] arr) {
        if (arr.length == 0) return -1;

        int rightSum = getSum(arr);
        int leftSum = 0;

        for (int i = 0; i < arr.length; i++) {
            rightSum -= arr[i];
            if (leftSum == rightSum) return i;
            leftSum += arr[i];
        }

        return -1;
    }

    private int getSum(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result += num;
        }
        return result;
    }
}
