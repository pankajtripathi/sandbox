package arrays;

public class MedianTwoSortedArraysSameLength {
    public static void main(String[] args) {
        int ar1[] = {1, 12, 15, 26, 38};
        int ar2[] = {2, 13, 17, 30, 45};
        System.out.println(findMedianByMerging(ar1, ar2));
        System.out.println(findByBinarySearch(ar1, ar2, 0, ar1.length - 1, 0, ar2.length - 1));
    }

    private static int findMedianByMerging(int[] ar1, int[] ar2) {
        int[] mergeArray = MergeTwoSortedArrays.merge(ar1, ar2);

        int n = ar1.length + ar2.length;
        int mid = n / 2;

        return (mergeArray[mid] + mergeArray[mid - 1]) / 2;
    }

    private static int findByBinarySearch(int[] ar1, int[] ar2, int start1, int end1, int start2, int end2) {
        int len = end1 - start1 + 1;
        if(len == 1) {
            return (ar1[start1] + ar2[start2]) / 2;
        }

        if (len == 2) {
            return (Math.max(ar1[start1], ar2[start2]) + Math.min(ar1[end1], ar2[end2])) / 2;
        }

        int median1 = getMedian(ar1, start1, len);
        int median2 = getMedian(ar2, start2, len);

        if (median1 == median2) return median1;

        if (median1 > median2) {
            return findByBinarySearch(ar1,
                    ar2,
                    start1,
                    end1 - len / 2,
                    start2 + len/ 2,
                    end2);
        }
        return findByBinarySearch(ar1,
                ar2,
                start1 + len / 2,
                end1,
                start2,
                end2 - len / 2);
    }

    private static int getMedian(int[] arr, int start, int len) {
        int mid = (start + len) / 2;
        if (len % 2 == 0) {
            return (arr[mid] + arr[mid - 1]) / 2;
        } else {
            return arr[mid];
        }
    }
}
