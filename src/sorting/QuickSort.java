package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String args[]){
        QuickSort obj = new QuickSort();
        int a[] = {7, 1, 3, 9, 2, 12};
        obj.sort(a, 0, a.length-1);

        System.out.println(Arrays.toString(a));
    }

    private void sort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0 || arr.length ==1) return;

        if (low > high) return;

        int mid = (low + high) / 2;
        int pivot = arr[mid];
        int i = low;
        int j = high;

        while (i <= j) {
            // if less than low point then keep moving ahead
            while (arr[i] < pivot)
                i++;

            // if greater than high point then keep moving backwards
            while (arr[j] > pivot)
                j--;

            // swap them when above conditions are not satisfied but make sure that i is less than j
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
        }

        if (high > i)
            sort(arr, i, high);
        if (low < j)
            sort(arr, low, j);

    }
}
