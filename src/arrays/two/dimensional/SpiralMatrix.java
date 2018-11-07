package arrays.two.dimensional;

public class SpiralMatrix {
    public static void main(String[] args) {
        int matrix[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        new SpiralMatrix().printSpiral(matrix);
    }

    private void printSpiral(int[][] matrix) {
        if (matrix.length == 0 || matrix == null || matrix[0].length == 0) return;

        int leftCol = 0;
        int rightCol = matrix[0].length - 1;

        int topRow = 0;
        int bottomRow = matrix.length - 1;

        while (leftCol <= rightCol && topRow <= bottomRow) {
            // Print elements from left column to right column for top row
            for (int i = leftCol; i <= rightCol; i++) {
                System.out.println(matrix[topRow][i]);
            }
            topRow++;

            // Print elements from top row to bottom row for right column
            for (int i = topRow; i <= bottomRow; i++) {
                System.out.println(matrix[i][rightCol]);
            }
            rightCol--;

            // Print elements from right column to left column for bottom row
            for (int i = rightCol; i >= leftCol ; i--) {
                System.out.println(matrix[bottomRow][i]);
            }
            bottomRow--;

            // Print elements from bottom row to top row for left column
            for (int i = bottomRow; i >= topRow ; i--) {
                System.out.println(matrix[i][leftCol]);
            }
            leftCol++;
        }
    }
}
