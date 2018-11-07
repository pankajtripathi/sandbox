package arrays;

import java.util.Arrays;

public class InPlaceReverse {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        reverse(numbers);
    }

    private static void reverse(int[] numbers) {
        for (int i = 0; i < numbers.length / 2; i++) {
            int reverseIndex = numbers.length - 1 - i;

            int temp = numbers[i];
            numbers[i] = numbers[reverseIndex];
            numbers[reverseIndex] = temp;
        }

        System.out.println(Arrays.toString(numbers));
    }

}
