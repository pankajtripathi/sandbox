package graphs;


/*

You are given a m x n 2D grid initialized with these three possible values.
-1 => A wall or an obstacle.
0 => A gate.
INF => Infinity means an empty room.

We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is
less than 2147483647. Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate,
it should be filled with INF.

Example:

Given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF

After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4


This problem is also similar to Number of Islands problem on leetcode. In order to solve that problem do the following.
* To count the number of islands in solve function check for '1' and add counter
*
*        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    fill(grid, i, j);
                }
            }
         }
         return count;

* */
public class WallsAndGates {
    public static void main(String[] args) {
        int[][] rooms = {
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}
        };

        new WallsAndGates().wallsAndGates(rooms);

        for(int i = 0; i< rooms.length; i++){
            for (int j = 0; j < rooms[0].length; j++) {
                System.out.print(rooms[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        int M = rooms.length;
        int N = rooms[0].length;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (rooms[i][j] == 0)
                    fill(rooms, i, j, 0);
            }
        }
    }

    private void fill(int[][] board, int x, int y, int distance) {
        if (isNotFeasible(board, x, y, distance)) return;

        board[x][y] = distance;

        fill(board, x + 1, y, distance + 1);
        fill(board, x - 1, y, distance + 1);
        fill(board, x, y + 1, distance + 1);
        fill(board, x, y - 1, distance + 1);
    }

    private boolean isNotFeasible(int[][] board, int x, int y, int distance) {
        return x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] < distance;
    }
}
