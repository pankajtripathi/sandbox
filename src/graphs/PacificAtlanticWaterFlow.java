package graphs;

import java.util.ArrayList;
import java.util.List;

/*
Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent,
the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right
and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:
The order of returned grid coordinates does not matter.
Both m and n are less than 150.
Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
* */
public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };

        System.out.println(new PacificAtlanticWaterFlow().pacificAtlantic(matrix));
    }

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;

        int M = matrix.length;
        int N = matrix[0].length;

        boolean[][] pacificVisited = new boolean[M][N];
        boolean[][] atlanticVisited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            markBoundary(matrix, pacificVisited, i, 0, Integer.MIN_VALUE);
            markBoundary(matrix, atlanticVisited, i, N - 1, Integer.MIN_VALUE);
        }

        for (int i = 0; i < N; i++) {
            markBoundary(matrix, pacificVisited, 0, i, Integer.MIN_VALUE);
            markBoundary(matrix, atlanticVisited, M - 1, i, Integer.MIN_VALUE);
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                    result.add(new int[] {i, j});
                }
            }
        }

        return result;
    }

    private void markBoundary(int[][] matrix, boolean[][] visited, int x, int y, int height) {
        if (isNotFeasible(matrix, visited, x, y, height)) return;

        visited[x][y] = true;

        markBoundary(matrix, visited, x + 1, y, matrix[x][y]);
        markBoundary(matrix, visited, x - 1, y, matrix[x][y]);
        markBoundary(matrix, visited, x, y + 1, matrix[x][y]);
        markBoundary(matrix, visited, x, y - 1, matrix[x][y]);
    }

    private boolean isNotFeasible(int[][] matrix, boolean[][] visited, int x, int y, int height) {
        return x < 0
                || x >= matrix.length
                || y < 0
                || y >= matrix[0].length
                || visited[x][y]
                || matrix[x][y] < height;
    }
}
