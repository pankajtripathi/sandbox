package math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("999", "999"));
    }

    public String multiply(String num1, String num2) {
        if (num1.length() == 1 && num1.equals("0")) return "0";
        if (num2.length() == 1 && num2.equals("0")) return "0";

        List<Integer> result = new ArrayList<>(Collections.nCopies(num1.length() + num2.length(), 0));

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                System.out.println(result.get(i + j + 1) + " " + num1.charAt(i) + " " + num2.charAt(j));
                int product = result.get(i + j + 1)  + getNum(num1.charAt(i)) * getNum(num2.charAt(j));
                int carry = result.get(i + j) + product / 10;

                result.set(i + j, carry);
                result.set(i + j + 1, product % 10);
            }
        }

        int firstZero = 0;
        while (firstZero < result.size() && result.get(firstZero) == 0)
            firstZero++;
        result = result.subList(firstZero, result.size());

        StringBuilder res = new StringBuilder();
        for (int num : result)
            res.append(String.valueOf(num));
        return res.length() > 0 ? res.toString() : "";
    }

    private int getNum(char c) {
        return Character.getNumericValue(c);
    }
}
