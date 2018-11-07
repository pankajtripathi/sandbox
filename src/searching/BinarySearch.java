package searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 9, 12, 23};
        System.out.println("Index: " + new BinarySearch().search(arr, 12));
    }

    private int search(int[] arr, int num) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == num) return mid;
            else if (num > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
