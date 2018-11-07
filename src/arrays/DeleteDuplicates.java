package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DeleteDuplicates {
    public static void main(String[] args) {
        int[] numbers1 = {4, 3, 2, 7, 8, 2, 3, 1};
        new DeleteDuplicates().deleteDuplicates(numbers1);

        int[] numbers = {4, 3, 2, 7, 8, 2, 3, 1};
        new DeleteDuplicates().efficientWay(numbers);
    }

    private void efficientWay(int[] numbers) {
        if (numbers.length == 0) return;

        int writeIndex = 1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[writeIndex - 1] != numbers[i]) {
                numbers[writeIndex++] = numbers[i];
            }
        }

        System.out.println(writeIndex);
    }

    private void deleteDuplicates(int[] numbers) {
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            if (seen.contains(numbers[i])) {
                numbers[i] = 0;
            }
            seen.add(numbers[i]);
        }

        System.out.println(Arrays.toString(numbers));
    }
}
