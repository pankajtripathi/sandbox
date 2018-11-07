package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SumOfNumberInArray {
    public static void main(String[] args) {
        int[] arr =  {1, 4, 45, 6, 10, -8};
        System.out.println(findSumInArray(arr, 16));

        System.out.println(findSumByHashing(arr, 16));
    }

    private static boolean findSumInArray(int[] arr, int num) {
        int low = 0;
        int high = arr.length - 1;

        Arrays.sort(arr);

        while (low <= high) {
            if (arr[low] + arr[high] == num) return true;

            if (arr[low] + arr[high] < num) {
                low++;
            } else if (arr[low] + arr[high] > num) {
                high--;
            }
        }
        return false;
    }

    private static boolean findSumByHashing(int[] arr, int num) {
        HashSet<Integer> set = new HashSet<>();

        for (int val : arr) {
            if (set.contains(val)) {
                return true;
            }
            else set.add(num-val);
        }
        return false;
    }
}
