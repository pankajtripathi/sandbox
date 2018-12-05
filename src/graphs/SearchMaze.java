package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchMaze {
    public enum Color { BLACK, WHITE }

    public List<Coordinate> search(List<List<Color>> maze,
                                   Coordinate source,
                                   Coordinate exit) {
        List<Coordinate> path = new ArrayList<>();
        if (!isSearchHelper(maze, source, exit, path)) {
            return Collections.EMPTY_LIST;
        }
        return path;
    }

    private boolean isSearchHelper(List<List<Color>> maze,
                                   Coordinate current,
                                   Coordinate exit,
                                   List<Coordinate> path) {
        if (!isFeasible(maze, current)) {
            return false;
        }
        path.add(current);
        maze.get(current.x).set(current.y, Color.BLACK);

        if (current.equals(exit)) {
            return true;
        }

        final int[][] directions = { {0, 1},{0, -1}, {1, 0}, {-1, 0} };
        for (int[] direction : directions) {
            Coordinate next = new Coordinate(current.x + direction[0], current.y + direction[1]);
            if (isSearchHelper(maze, next, exit, path)) {
                return true;
            }
        }

        // Cannot find path so remove the last element added in path
        path.remove(path.size() - 1);
        return false;
    }

    private boolean isFeasible(List<List<Color>> maze, Coordinate current) {
        return current.x >= 0
                && current.x < maze.size()
                && current.y >= 0
                && current.y < maze.get(current.x).size()
                && maze.get(current.x).get(current.y) == Color.WHITE;
    }

    public static void main(String[] args) {
        List<List<Color>> maze = new ArrayList<>(Collections.nCopies(10, new ArrayList<>()));

        List<Color> firstRow = new ArrayList<>(Collections.nCopies(10, Color.WHITE));
        firstRow.set(0, Color.BLACK);
        firstRow.set(1, Color.WHITE);
        firstRow.set(2, Color.WHITE);
        firstRow.set(3, Color.WHITE);
        firstRow.set(4, Color.WHITE);
        firstRow.set(5, Color.WHITE);
        firstRow.set(6, Color.BLACK);
        firstRow.set(7, Color.BLACK);
        firstRow.set(8, Color.WHITE);
        firstRow.set(9, Color.WHITE);

        List<Color> secondRow = new ArrayList<>(Collections.nCopies(10, Color.WHITE));
        secondRow.set(0, Color.WHITE);
        secondRow.set(1, Color.WHITE);
        secondRow.set(2, Color.BLACK);
        secondRow.set(3, Color.WHITE);
        secondRow.set(4, Color.WHITE);
        secondRow.set(5, Color.WHITE);
        secondRow.set(6, Color.WHITE);
        secondRow.set(7, Color.WHITE);
        secondRow.set(8, Color.WHITE);
        secondRow.set(9, Color.WHITE);

        List<Color> thirdRow = new ArrayList<>(Collections.nCopies(10, Color.WHITE));
        thirdRow.set(0, Color.BLACK);
        thirdRow.set(1, Color.WHITE);
        thirdRow.set(2, Color.BLACK);
        thirdRow.set(3, Color.WHITE);
        thirdRow.set(4, Color.WHITE);
        thirdRow.set(5, Color.BLACK);
        thirdRow.set(6, Color.BLACK);
        thirdRow.set(7, Color.WHITE);
        thirdRow.set(8, Color.BLACK);
        thirdRow.set(9, Color.BLACK);

        List<Color> fourthRow = new ArrayList<>(Collections.nCopies(10, Color.WHITE));
        fourthRow.set(0, Color.WHITE);
        fourthRow.set(1, Color.WHITE);
        fourthRow.set(2, Color.WHITE);
        fourthRow.set(3, Color.BLACK);
        fourthRow.set(4, Color.BLACK);
        fourthRow.set(5, Color.BLACK);
        fourthRow.set(6, Color.WHITE);
        fourthRow.set(7, Color.WHITE);
        fourthRow.set(8, Color.BLACK);
        fourthRow.set(9, Color.WHITE);

        List<Color> fifthRow = new ArrayList<>(Collections.nCopies(10, Color.WHITE));
        fifthRow.set(0, Color.WHITE);
        fifthRow.set(1, Color.BLACK);
        fifthRow.set(2, Color.BLACK);
        fifthRow.set(3, Color.WHITE);
        fifthRow.set(4, Color.WHITE);
        fifthRow.set(5, Color.WHITE);
        fifthRow.set(6, Color.WHITE);
        fifthRow.set(7, Color.WHITE);
        fifthRow.set(8, Color.WHITE);
        fifthRow.set(9, Color.WHITE);

        List<Color> sixthRow = new ArrayList<>(Collections.nCopies(10, Color.WHITE));
        sixthRow.set(0, Color.WHITE);
        sixthRow.set(1, Color.BLACK);
        sixthRow.set(2, Color.BLACK);
        sixthRow.set(3, Color.WHITE);
        sixthRow.set(4, Color.WHITE);
        sixthRow.set(5, Color.BLACK);
        sixthRow.set(6, Color.WHITE);
        sixthRow.set(7, Color.BLACK);
        sixthRow.set(8, Color.BLACK);
        sixthRow.set(9, Color.WHITE);

        List<Color> seventhRow = new ArrayList<>(Collections.nCopies(10, Color.WHITE));
        seventhRow.set(0, Color.WHITE);
        seventhRow.set(1, Color.WHITE);
        seventhRow.set(2, Color.WHITE);
        seventhRow.set(3, Color.WHITE);
        seventhRow.set(4, Color.BLACK);
        seventhRow.set(5, Color.WHITE);
        seventhRow.set(6, Color.WHITE);
        seventhRow.set(7, Color.WHITE);
        seventhRow.set(8, Color.WHITE);
        seventhRow.set(9, Color.WHITE);

        List<Color> eigthRow = new ArrayList<>(Collections.nCopies(10, Color.WHITE));
        eigthRow.set(0, Color.BLACK);
        eigthRow.set(1, Color.WHITE);
        eigthRow.set(2, Color.BLACK);
        eigthRow.set(3, Color.WHITE);
        eigthRow.set(4, Color.BLACK);
        eigthRow.set(5, Color.WHITE);
        eigthRow.set(6, Color.BLACK);
        eigthRow.set(7, Color.WHITE);
        eigthRow.set(8, Color.WHITE);
        eigthRow.set(9, Color.WHITE);

        List<Color> ninthRow = new ArrayList<>(Collections.nCopies(10, Color.WHITE));
        ninthRow.set(0, Color.BLACK);
        ninthRow.set(1, Color.WHITE);
        ninthRow.set(2, Color.BLACK);
        ninthRow.set(3, Color.BLACK);
        ninthRow.set(4, Color.WHITE);
        ninthRow.set(5, Color.WHITE);
        ninthRow.set(6, Color.WHITE);
        ninthRow.set(7, Color.BLACK);
        ninthRow.set(8, Color.BLACK);
        ninthRow.set(9, Color.BLACK);

        List<Color> tenthRow = new ArrayList<>(Collections.nCopies(10, Color.WHITE));
        tenthRow.set(0, Color.WHITE);
        tenthRow.set(1, Color.WHITE);
        tenthRow.set(2, Color.WHITE);
        tenthRow.set(3, Color.WHITE);
        tenthRow.set(4, Color.WHITE);
        tenthRow.set(5, Color.WHITE);
        tenthRow.set(6, Color.WHITE);
        tenthRow.set(7, Color.BLACK);
        tenthRow.set(8, Color.BLACK);
        tenthRow.set(9, Color.WHITE);

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

        List<Coordinate> path = new SearchMaze().search(maze,
                new Coordinate(9, 0),
                new Coordinate(0, 9));

        System.out.println("Paths");
        for (Coordinate coordinate : path) {
            System.out.println(coordinate.x + " " + coordinate.y);
        }
    }
}


