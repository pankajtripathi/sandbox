package arrays;

/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
* */
public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                        {'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}
        };

        String word1 = "ABCB";
        String word2 = "SEE";

        System.out.println(new WordSearch().exist(board, word1));
        System.out.println(new WordSearch().exist(board, word2));
    }

    public boolean exist(char[][] board, String word) {
        int M = board.length;
        int N = board[0].length;

        boolean[][] visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (word.charAt(0) == board[i][j] && dfs(board, i, j, visited, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, boolean[][] visited, String word, int index) {
        if (index == word.length()) return true;
        if (isNotFeasible(board, i, j, visited, word, index)) return false;

        visited[i][j] = true;
        if (dfs(board, i, j + 1, visited, word, index + 1)
                || dfs(board, i, j - 1, visited, word, index + 1)
                || dfs(board, i + 1, j, visited, word, index + 1)
                || dfs(board, i - 1, j, visited, word, index + 1)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }

    private boolean isNotFeasible(char[][] board, int i, int j, boolean[][] visited, String word, int index) {
        return (i < 0
                || i >= board.length
                || j < 0 || j >= board[0].length
                || board[i][j] != word.charAt(index)
                || visited[i][j]) ;
    }
}
