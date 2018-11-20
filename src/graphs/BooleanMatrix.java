package graphs;

import java.util.*;

// Flip color of the coordinate passed and also all the adjacent cells
// true => black
// false => white
public class BooleanMatrix {
    private void flipColor(List<List<Boolean>> maze, int x, int y) {
        final int[][] directions = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
        Queue<Coordinate> queue = new LinkedList<>();

        // Flip color and add to the queue
        boolean color =  maze.get(x).get(y);
        maze.get(x).set(y, !color);
        queue.add(new Coordinate(x, y));

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            // for all adjacent cells if they are feasible then flip color
            for (int[] direction : directions) {
                Coordinate next = new Coordinate(current.x + direction[0], current.y + direction[1]);

                if (isFeasible(maze, next, color)) {
                    maze.get(next.x).set(next.y, !color);
                    queue.add(next);
                }
            }
        }
    }

    private boolean isFeasible(List<List<Boolean>> maze, Coordinate current, boolean color) {
        return current.x >= 0
                && current.y >= 0
                && current.x < maze.size()
                && current.y < maze.get(current.x).size()
                && maze.get(current.x).get(current.y) == color;
    }


    public static void main(String[] args) {
        List<List<Boolean>> maze = new ArrayList<>(Collections.nCopies(10, new ArrayList<>()));

        List<Boolean> firstRow = new ArrayList<>(Collections.nCopies(10, false));
        firstRow.set(0, true);
        firstRow.set(1, false);
        firstRow.set(2, true);
        firstRow.set(3, false);
        firstRow.set(4, false);
        firstRow.set(5, false);
        firstRow.set(6, true);
        firstRow.set(7, true);
        firstRow.set(8, true);
        firstRow.set(9, true);

        List<Boolean> secondRow = new ArrayList<>(Collections.nCopies(10, false));
        secondRow.set(0, false);
        secondRow.set(1, false);
        secondRow.set(2, true);
        secondRow.set(3, false);
        secondRow.set(4, false);
        secondRow.set(5, true);
        secondRow.set(6, false);
        secondRow.set(7, false);
        secondRow.set(8, true);
        secondRow.set(9, true);

        List<Boolean> thirdRow = new ArrayList<>(Collections.nCopies(10, false));
        thirdRow.set(0, true);
        thirdRow.set(1, true);
        thirdRow.set(2, true);
        thirdRow.set(3, false);
        thirdRow.set(4, false);
        thirdRow.set(5, true);
        thirdRow.set(6, true);
        thirdRow.set(7, false);
        thirdRow.set(8, true);
        thirdRow.set(9, true);

        List<Boolean> fourthRow = new ArrayList<>(Collections.nCopies(10, false));
        fourthRow.set(0, false);
        fourthRow.set(1, true);
        fourthRow.set(2, false);
        fourthRow.set(3, true);
        fourthRow.set(4, true);
        fourthRow.set(5, true);
        fourthRow.set(6, true);
        fourthRow.set(7, false);
        fourthRow.set(8, true);
        fourthRow.set(9, false);

        List<Boolean> fifthRow = new ArrayList<>(Collections.nCopies(10, false));
        fifthRow.set(0, true);
        fifthRow.set(1, true);
        fifthRow.set(2, true);
        fifthRow.set(3, true);
        fifthRow.set(4, true);
        fifthRow.set(5, true);
        fifthRow.set(6, true);
        fifthRow.set(7, true);
        fifthRow.set(8, false);
        fifthRow.set(9, false);

        List<Boolean> sixthRow = new ArrayList<>(Collections.nCopies(10, false));
        sixthRow.set(0, true);
        sixthRow.set(1, true);
        sixthRow.set(2, true);
        sixthRow.set(3, true);
        sixthRow.set(4, true);
        sixthRow.set(5, true);
        sixthRow.set(6, true);
        sixthRow.set(7, true);
        sixthRow.set(8, true);
        sixthRow.set(9, true);

        List<Boolean> seventhRow = new ArrayList<>(Collections.nCopies(10, false));
        seventhRow.set(0, true);
        seventhRow.set(1, true);
        seventhRow.set(2, true);
        seventhRow.set(3, true);
        seventhRow.set(4, true);
        seventhRow.set(5, true);
        seventhRow.set(6, true);
        seventhRow.set(7, false);
        seventhRow.set(8, false);
        seventhRow.set(9, true);

        List<Boolean> eigthRow = new ArrayList<>(Collections.nCopies(10, false));
        eigthRow.set(0, true);
        eigthRow.set(1, true);
        eigthRow.set(2, true);
        eigthRow.set(3, true);
        eigthRow.set(4, true);
        eigthRow.set(5, true);
        eigthRow.set(6, true);
        eigthRow.set(7, false);
        eigthRow.set(8, false);
        eigthRow.set(9, false);

        List<Boolean> ninthRow = new ArrayList<>(Collections.nCopies(10, false));
        ninthRow.set(0, true);
        ninthRow.set(1, true);
        ninthRow.set(2, true);
        ninthRow.set(3, true);
        ninthRow.set(4, true);
        ninthRow.set(5, true);
        ninthRow.set(6, true);
        ninthRow.set(7, true);
        ninthRow.set(8, true);
        ninthRow.set(9, true);

        List<Boolean> tenthRow = new ArrayList<>(Collections.nCopies(10, false));
        tenthRow.set(0, true);
        tenthRow.set(1, true);
        tenthRow.set(2, true);
        tenthRow.set(3, true);
        tenthRow.set(4, true);
        tenthRow.set(5, true);
        tenthRow.set(6, true);
        tenthRow.set(7, true);
        tenthRow.set(8, true);
        tenthRow.set(9, false);

        maze.set(0, firstRow);
        maze.set(1, secondRow);
        maze.set(2, thirdRow);
        maze.set(3, fourthRow);
        maze.set(4, fifthRow);
        maze.set(5, sixthRow);
        maze.set(6, seventhRow);
        maze.set(7, eigthRow);
        maze.set(8, ninthRow);
        maze.set(9, tenthRow);

        new BooleanMatrix().flipColor(maze, 3, 6);
        System.out.println(maze);
    }
}
