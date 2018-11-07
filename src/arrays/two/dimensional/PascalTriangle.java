package arrays.two.dimensional;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        new PascalTriangle().generatePascalTriangle(5);
    }

    private void generatePascalTriangle(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
           List<Integer> currentRow = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                // add number from prev row and number at column j and j - 1
                int num = (j > 0 && j < i) ? pascal.get(i - 1).get(j) + pascal.get(i - 1).get(j - 1) : 1;
                currentRow.add(num);
            }
            pascal.add(currentRow);
        }

        System.out.println(pascal);
    }
}
