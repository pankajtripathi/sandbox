package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DutchFlag {
    public static void main(String[] args) {
        int[] arr1 = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        System.out.println(Arrays.toString(dutchFlagForArray(arr1)));

        int[] arr2 = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        List<Integer> B = Arrays.stream(arr2).boxed().collect(Collectors.toList());
        dutchFlag(1, B);
        System.out.println(B);
    }

    // Useful when order doesn't matter. You just want to have equal or smaller first
    private static void dutchFlag(int pivotIndex, List<Integer> A) {
        int pivot = A.get(pivotIndex);

        int smaller = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) < pivot) {
                Collections.swap(A, i, smaller++);
            }
        }
    }

    private static int[] dutchFlagForArray(int[] arr) {
        int mid = 0;
        int low = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                mid++;
                low++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                swap(arr, mid, high);
                high--;
            }
        }

        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
