package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Java method to find missing number in array of size n containing
 * numbers from 1 to n only.
 * can be used to find missing elements on integer array of
 * numbers from 1 to 100 or 1 - 1000
 */
public class FindMissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 7, 9, 8, 10};
        printMissingNumberSizeGiven(arr, 10);
        printMissingNumber(arr);

        int[] numbers = {4, 3, 2, 7, 8, 2, 3, 1};
        findMissingNumber(numbers);
    }

    private static void findMissingNumber(int[] numbers) {
        List<Integer> result = new ArrayList<>();

        // Use the numbers as index. That's the reason - 1 to get val.
        // for index val if the number at that index is positive then change it to negative number.
        for (int number : numbers) {
            int val = Math.abs(number) - 1;
            if (numbers[val] > 0) numbers[val] = -numbers[val];
        }

        // Search for number that is positive. If a number is positive that means it's (index + 1) is missing
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                result.add(i + 1);
            }
        }

        System.out.println("Missing numbers are => " + result);
    }

    private static void printMissingNumber(int[] arr) {
        // sum = (n+1) * (n+2) / 2
        int n = arr.length;
        int requiredSum = ((n + 1) * (n + 2)) / 2;
        int acutalSum = 0;

        for (int num : arr) {
            acutalSum += num;
        }

        System.out.println("Missing number when size not provided  => " + (requiredSum - acutalSum));
    }

    private static void printMissingNumberSizeGiven(int[] numbers, int count) {
        // sum = n * (n+1) / 2
        int requiredSum = (count * (count + 1)) / 2;
        int acutalSum = 0;

        for (int num : numbers) {
            acutalSum += num;
        }

        System.out.println("Missing number when size is provided => " + (requiredSum - acutalSum));
    }
}
