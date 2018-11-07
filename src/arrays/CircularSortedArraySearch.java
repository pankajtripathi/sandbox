package arrays;

public class CircularSortedArraySearch {
    public static void main(String[] args) {
        int[] arr = {5, 9, 14, 1, 3, 4};
        System.out.println("Index: " + new CircularSortedArraySearch().findElement(arr, 9));
    }

    private int findElement(int[] arr, int num) {
        if (arr == null || arr.length == 0) return -1;
        int low = 0;
        int high = arr.length - 1;
        int mid;

        if (num < arr[low] && num > arr[high]) return -1;

        while (low <= high) {
            mid = (low + high) / 2;

            // Case-1 element found at mid.
            if (num == arr[mid]) return mid;

            //Case-2 right side of mid is sorted.
            if (arr[mid] <= arr[high]) {
                if (num > arr[mid] && num <= arr[high]) low = mid + 1;
                else high = mid - 1;
            }

            //Case-3 left side of mid is sorted.
            if (arr[mid] >= arr[low]) {
                if (num < arr[mid] && num >= arr[low]) high = mid - 1;
                else low = mid + 1;
            }

        }

        return -1;
    }
}
