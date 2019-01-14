package strings;

public class ReverseCharacters {
    public static void main(String[] args) {
        char[] arr = {'a', 'b', ' ', 'c', ' ', 'd'};
        new ReverseCharacters().reverseChars(arr);
        System.out.println(arr);
    }

    private void reverseChars(char[] arr) {
        reverse(arr, 0, arr.length - 1);

        int i = 0;
        int j = 0;

        while (i <= arr.length && j <= arr.length) {
            if (j == arr.length || arr[j] == ' ') {
                reverse(arr, i, j - 1);
                j++;
                i = j;
            } else {
                j++;
            }
        }
    }

    private void reverse(char[] arr, int low, int high) {
        while (low < high) {
            char temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;

            low++;
            high--;
        }
    }
}
