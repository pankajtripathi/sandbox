package graphs;

import java.util.*;

/*
* Let A be a 2D array whose entries are either W or B. Write a program that takes A and replaces all Ws that cannot
* reach the boundary with a B.
* */
public class EnclosedRegions {
    public void fillSurroundedRegion(List<List<Character>> board) {
        for (int i = 0; i < board.size(); i++) {
            if (board.get(i).get(0) == 'W') {
                markBoundary(board, i, 0);
            }
            if (board.get(i).get(board.get(i).size() - 1) == 'W') {
                markBoundary(board, i, board.get(i).size() - 1);
            }
        }

        for (int i = 0; i < board.get(0).size(); i++) {
            if (board.get(0).get(i) == 'W') {
                markBoundary(board, 0, i);
            }
            if (board.get(board.size() - 1).get(i) == 'W') {
                markBoundary(board, board.size() - 1, i);
            }
        }

        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(i).size(); j++) {
                // if it's not a boundry edge set it to black else white
                board.get(i).set(j, board.get(i).get(j) != 'E' ? 'B' : 'W');
            }
        }
    }


    private void markBoundary(List<List<Character>> board, int x, int y) {
        Queue<Coordinate> queue = new LinkedList<>();
        Coordinate point = new Coordinate(x, y);
        queue.add(point);

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();

            if (isFeasible(board, current)) {
                // Mark the current point as an edge
                board.get(current.x).set(current.y, 'E');

                queue.add(new Coordinate(current.x, current.y + 1));
                queue.add(new Coordinate(current.x, current.y - 1));
                queue.add(new Coordinate(current.x + 1, current.y));
                queue.add(new Coordinate(current.x - 1, current.y));
            }
        }
    }


    private boolean isFeasible(List<List<Character>> board, Coordinate current) {
        return current.x >= 0
                && current.x < board.size()
                && current.y >= 0
                && current.y < board.get(current.x).size()
                && board.get(current.x).get(current.y) == 'W';
    }

    public static void main(String[] args) {
        List<List<Character>> board = new ArrayList<>(Collections.nCopies(4, new ArrayList<>()));

        List<Character> firstRow = new ArrayList<>(Collections.nCopies(4, 'B'));
        firstRow.set(0, 'B');
        firstRow.set(1, 'B');
        firstRow.set(2, 'B');
        firstRow.set(3, 'B');

        List<Character> secondRow = new ArrayList<>(Collections.nCopies(4, 'B'));
        secondRow.set(0, 'W');
        secondRow.set(1, 'B');
        secondRow.set(2, 'W');
        secondRow.set(3, 'B');

        List<Character> thirdRow = new ArrayList<>(Collections.nCopies(4, 'B'));
        thirdRow.set(0, 'B');
        thirdRow.set(1, 'W');
        thirdRow.set(2, 'W');
        thirdRow.set(3, 'B');

        List<Character> fourthRow = new ArrayList<>(Collections.nCopies(4, 'B'));
        fourthRow.set(0, 'B');
        fourthRow.set(1, 'B');
        fourthRow.set(2, 'B');
        fourthRow.set(3, 'B');

        board.set(0, firstRow);
        board.set(1, secondRow);
        board.set(2, thirdRow);
        board.set(3, fourthRow);

        new EnclosedRegions().fillSurroundedRegion(board);
        System.out.println(board);
    }
}
