package graphs;


/*
Let's play the minesweeper game (Wikipedia, online game)!

You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine,
'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent
(above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to
this revealed square, and finally 'X' represents a revealed mine.

Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'),
return the board after revealing this position according to the following rules:

1. If a mine ('M') is revealed, then the game is over - change it to 'X'.
2. If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its
adjacent unrevealed squares should be revealed recursively.
3. If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8')
representing the number of adjacent mines.

Return the board when no more squares will be revealed.

Input:

[['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'M', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E']]

Click : [3,0]

Output:

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]
* */
class Minesweeper {
    public static void main(String[] args) {
        char[][] board = {
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        };

        int[] click = {3, 0};

        new Minesweeper().updateBoard(board, click);

        for(int i = 0; i< board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0) return null;
        int m = board.length;
        int n = board[0].length;

        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
        } else if (board[click[0]][click[1]] == 'E') {
            revealBoard(board, click[0], click[1], m, n);
        }

        return board;
    }

    private void revealBoard(char[][] board, int i, int j, int m, int n) {
        if (isNotFeasible(board, i, j)) return;

        if (board[i][j] == 'E') {
            board[i][j] = countMines(board, i, j, m, n);
            if (board[i][j] == 'B') {
//                revealBoard(board, i - 1, j, m, n);
//                revealBoard(board, i + 1, j, m, n);
//                revealBoard(board, i, j - 1, m, n);
//                revealBoard(board, i, j + 1, m, n);
//
//                revealBoard(board, i - 1, j - 1, m, n);
//                revealBoard(board, i - 1, j + 1, m, n);
//                revealBoard(board, i + 1, j + 1, m, n);
//                revealBoard(board, i + 1, j - 1, m, n);

                for (int row = i - 1; row <= i + 1 && row < m; row++) {
                    for (int col = j - 1; col <= j + 1 && col < n; col++) {
                        if (row >= 0 && col >= 0 && board[row][col] == 'M') {
                            revealBoard(board, row, col, m, n);
                        }
                    }
                }
            }
        }
    }

    private boolean isNotFeasible(char[][] board, int i, int j) {
        return i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 'B';
    }

    private char countMines(char[][] board, int i, int j, int m, int n) {
        int count = 0;

        for (int row = i - 1; row <= i + 1 && row < m; row++) {
            for (int col = j - 1; col <= j + 1 && col < n; col++) {
                if (row >= 0 && col >= 0 && board[row][col] == 'M') {
                    count++;
                }
            }
        }

        /* Even these recursive approach is fine

        if (i > 0 && board[i - 1][j] == 'M') count++;
        if (i + 1 < m && board[i + 1][j] == 'M') count++;
        if (j > 0 && board[i][j - 1] == 'M') count++;
        if (j + 1 < n && board[i][j + 1] == 'M') count++;
        if (i > 0 && j > 0 && board[i - 1][j - 1] == 'M') count++;
        if (i + 1 < m && j + 1 < n && board[i + 1][j + 1] == 'M') count++;
        if (i > 0 && j + 1 < n && board[i - 1][j + 1] == 'M') count++;
        if (i + 1 < m && j > 0 && board[i + 1][j - 1] == 'M') count++;
        * */

        return count == 0 ? 'B' : (char) (count + '0');
    }
}
