package arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int a[] = { 0, 1, 0, 3, 12};
        int res[] = moveAtTheEnd(a);

        for (int re : res) {
            System.out.print(re + " ");
        }

        int res2[] = moveAtTheStart(a);

        System.out.println();
        for (int re : res2) {
            System.out.print(re + " ");
        }
    }

    private static int[] moveAtTheEnd(int[] arr) {
        int i = 0;
        int j = 0;

        while (i < arr.length && j < arr.length) {
            if (arr[j] == 0) {
                j++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                j++;
                i++;
            }
        }

        return arr;
    }

    private static int[] moveAtTheStart(int[] arr) {
        int i = arr.length - 1;
        int j = arr.length - 1;

        while (i >= 0 && j >= 0) {
            if (arr[j] == 0) {
                j--;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                j--;
                i--;
            }
        }

        return arr;
    }
}