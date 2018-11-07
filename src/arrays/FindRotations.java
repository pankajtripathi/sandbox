package arrays;

public class FindRotations {
    public static void main(String[] args) {
        int[] arr = {5, 9, 14, 1, 3, 4};
        System.out.println(new FindRotations().findRotations(arr));
    }

    private int findRotations(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        int mid;
        int n = arr.length;

        while (low <= high) {
            if (arr[low] <= arr[high]) return low; // already sorted and in order

            mid = (high +  low) / 2;
            int next = (mid + 1) % n;
            int prev = (mid - 1 + n) % n;

            if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) return mid; //mid is the start

            if (arr[mid] <= arr[high]) high = mid - 1;
            else if (arr[mid] >= arr[low]) low = mid + 1;
        }

        return -1;
    }


}
