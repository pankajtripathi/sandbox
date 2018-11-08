package arrays.two.dimensional;

import java.util.ArrayList;
import java.util.List;

public class    SpiralMatrix {
    public static void main(String[] args) {
        int matrix[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(new SpiralMatrix().printSpiral(matrix));
    }

    private List<Integer> printSpiral(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix == null || matrix[0].length == 0) return result;

        int leftCol = 0;
        int rightCol = matrix[0].length - 1;

        int topRow = 0;
        int bottomRow = matrix.length - 1;

        while (result.size() < matrix.length * matrix[0].length) {
            // Print elements from left column to right column for top row
            for (int i = leftCol; i <= rightCol; i++) {
                result.add(matrix[topRow][i]);
            }
            topRow++;

            // Print elements from top row to bottom row for right column
            for (int i = topRow; i <= bottomRow; i++) {
                result.add(matrix[i][rightCol]);
            }
            rightCol--;

            // Avoid duplicate rows
            if (bottomRow < topRow) break;
            // Print elements from right column to left column for bottom row
            for (int i = rightCol; i >= leftCol ; i--) {
                result.add(matrix[bottomRow][i]);
            }
            bottomRow--;

            // Avoid duplicate columns
            if (rightCol < leftCol) break;
            // Print elements from bottom row to top row for left column
            for (int i = bottomRow; i >= topRow ; i--) {
                result.add(matrix[i][leftCol]);
            }
            leftCol++;
        }

        return result;
    }
}
