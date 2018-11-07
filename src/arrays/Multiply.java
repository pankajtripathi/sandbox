package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Multiply {
    public static void main(String[] args) {
        List<Integer> num1 = new ArrayList<>();
        num1.add(4);
        num1.add(5);

        List<Integer> num2 = new ArrayList<>();
        num2.add(4);
        num2.add(5);

        System.out.println(multiply(num1, num2));
    }

    private static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));

        int sign = num1.get(0) < 0 || num2.get(0) < 0 ? -1 : 1;
        num1.set(0, Math.abs(num1.get(0)));
        num2.set(0, Math.abs(num2.get(0)));

        for (int i = num1.size() - 1; i >= 0; i--) {
            for (int j = num2.size() - 1 ; j >= 0; j--) {
                int product = result.get(i + j + 1) + num1.get(i) * num2.get(j);
                int carry = result.get(i + j) + product / 10;

                result.set(i + j + 1, product);
                result.set(i + j, carry);
                result.set(i + j + 1, product % 10);
            }
        }

        // remove leading zeroes
        int first_zero = 0;
        while (first_zero < result.size() && result.get(first_zero) == 0) {
            first_zero++;
        }
        result = result.subList(first_zero, result.size());
        result.set(0, result.get(0) * sign);

        if (result.isEmpty()) {
            return Arrays.asList(0);
        }

        return result;
    }
}
