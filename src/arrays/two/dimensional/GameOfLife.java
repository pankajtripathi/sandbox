package arrays.two.dimensional;

class GameOfLife {
    public static void main(String[] args) {
        GameOfLife obj = new GameOfLife();
        int[][] board = { {0, 1, 0}, {0, 1, 0}, {0, 1, 0}};
        int gen = 3;
        for (int i = 0; i < gen; i++) {
            board = obj.updateBoardForAGen(board);
        }
    }

    // 1. if the cell value is 1 -  is alive
    // 2. if the cell value is 0 - is dead
    public int[][] updateBoardForAGen(int[][] board) {
        // Update board for each cell
        int m = board.length;
        int n = board[0].length;
        int[][] newBoard = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newBoard[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = getCellCount(board, i, j);
                if (board[i][j] == 1) {
                    if (count < 2) newBoard[i][j] = 0;
                    if (count == 2 || count == 3) newBoard[i][j] = 1;
                    if (count > 3) newBoard[i][j] = 0;
                }
                if (board[i][j] == 0) {
                    if (count == 3) newBoard[i][j] = 1;
                }
            }
        }
        new GameOfLife().displayBoard(newBoard);
        return newBoard;
    }

    // This gives the count of cells
    public int getCellCount(int[][] board, int i, int j) {
        int count = 0;
        for (int row = i - 1; row <= i + 1 && row < board.length; row++) {
            for (int col = j - 1; col <= j + 1 && col < board[0].length; col++) {
                if (row >= 0 && col >= 0 && board[row][col] == 1) {
                    if (row == i && col == j) continue;
                    count++;
                }
            }
        }
        return count;
    }


    public void displayBoard(int[][] updatedBoard) {
        for (int i = 0; i < updatedBoard.length; i++) {
            for (int j = 0; j < updatedBoard[0].length; j++) {
                System.out.print(updatedBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}


/*
2D grid
cell - alive, dead
Any live cell with fewer than two live neighbours dies, as if by underpopulation.
Any live cell with two or three live neighbours lives on to the next generation.
Any live cell with more than three live neighbours dies, as if by overpopulation.
Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

3 generations, print out the board

0 1 0
0 1 0
0 1 0

0 0 0
1 1 1
0 0 0
*/


