package arrays;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] a = {1, 5, 9, 10, 15, 20};
        int[] b= {2, 3, 8, 13};

        System.out.println(Arrays.toString(merge(a, b)));
    }

    public static int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int indexA = 0;
        int indexB = 0;
        int indexRes = 0;

        while (indexA < a.length || indexB < b.length) {
            if (indexA < a.length && indexB < b.length) {
                if (a[indexA] <= b[indexB]) {
                    res[indexRes] = a[indexA];
                    indexA++;
                    indexRes++;
                } else {
                    res[indexRes] = b[indexB];
                    indexB++;
                    indexRes++;
                }
            }

            else if (indexA < a.length) {
                res[indexRes] = a[indexA];
                indexA++;
                indexRes++;
            }
            else if (indexB < b.length) {
                res[indexRes] = b[indexB];
                indexB++;
                indexRes++;
            }
        }

        return res;
    }
}
