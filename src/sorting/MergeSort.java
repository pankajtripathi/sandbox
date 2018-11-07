package sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int a[] = {7, 1, 3, 9, 2, 12};
        a = divide(a);
        System.out.println(Arrays.toString(a));
    }

    private static int[] divide(int[] b) {
        if (b.length <= 1) return b;

        int mid = b.length / 2;

        int[] left = new int[mid];
        int[] right;

        if (b.length % 2 == 0) {
            right = new int[mid];
        } else {
            right = new int[mid + 1];
        }

        for (int i = 0; i < mid; i++) {
            left[i] = b[i];
        }

        int x = 0;
        for (int i = mid; i < b.length; i++) {
            if (x < b.length) {
                right[x] = b[i];
                x++;
            }
        }

        left = divide(left);
        right = divide(right);

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int resLength = left.length + right.length;
        int[] res = new int[resLength];

        int indexL = 0;
        int indexR = 0;
        int indexRes = 0;

        while (indexL < left.length || indexR < right.length) {
            if (indexL < left.length && indexR < right.length) {
                if (left[indexL] <= right[indexR]) {
                    res[indexRes] = left[indexL];
                    indexL++;
                    indexRes++;
                }
                else {
                    res[indexRes] = right[indexR];
                    indexR++;
                    indexRes++;
                }
            }

            else if(indexL < left.length) {
                res[indexRes] = left[indexL];
                indexL++;
                indexRes++;
            }

            else if (indexR < right.length) {
                res[indexRes] = right[indexR];
                indexR++;
                indexRes++;
            }
        }

        return res;
    }


}
