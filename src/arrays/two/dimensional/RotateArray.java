package arrays.two.dimensional;

public class RotateArray {
    public static void main(String[] args) {
        int matrix[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        new RotateArray().rotateLeft(matrix);
        new RotateArray().printMatrix(matrix);

        new RotateArray().rotateRight(matrix);
        new RotateArray().printMatrix(matrix);
    }

    private void rotateLeft(int[][] matrix) {
        transpose(matrix);
        swapRows(matrix);
    }

    private void rotateRight(int[][] matrix) {
        swapRows(matrix);
        transpose(matrix);
    }

    private void swapRows(int[][] matrix) {
        for (int i = 0, k = matrix.length - 1; i < k; i++, k--) {
            int[] temp = matrix[i];
            matrix[i] = matrix[k];
            matrix[k] = temp;
        }
    }

    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void printMatrix(int[][] matrix){
        for (int[] aMatrix : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(aMatrix[j] + " ");
            }
            System.out.println();
        }
    }
}

