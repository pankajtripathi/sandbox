package arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RotateArray {
    public static void main(String[] args) {
        RotateArray obj = new RotateArray();
        int[] arr = {1,2,3,4,5,6,7};
        obj.rotate(arr, 3);
        obj.rotateEfficient(arr, 3);
    }

    private void rotateEfficient(int[] arr, int k) {
        k = k % arr.length;
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length -1);

        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    /*
    * Time complexity : O(n). One pass is used to put the numbers in the new array.
    * And another pass to copy the new array to the original one.
    * Space complexity : O(n). Another array of the same size is used.
    * */
    private void rotate(int[] arr, int k) {
        int[] nums = new int[arr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = arr[i];
        }

        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }



}
