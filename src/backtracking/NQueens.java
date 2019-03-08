package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
* The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
* That is a queen cannot be placed in same row, column or diagonally as other queen
* for n = 4 => [1, 3, 0, 2] [2, 0, 3, 1]
* */
class NQueens {
    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4));
    }

    private List<List<String>> solveNQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        nQueens(n, 0, new ArrayList<>(), result);

        List<List<String>> places = new ArrayList<>();
        for (List<Integer> res : result) {
            places.add(constructRes(res));
        }

        return places;
    }

    private void nQueens(int n, int row, List<Integer> colPlacement, List<List<Integer>> result) {
        if (row == n) {
            result.add(new ArrayList<>(colPlacement));
        } else {
            for (int i = 0; i < n; i++) {
                colPlacement.add(i);

                if (isValidPlacement(colPlacement)) {
                    nQueens(n, row + 1, colPlacement, result);
                }

                colPlacement.remove(colPlacement.size() - 1);
            }
        }
    }

    private boolean isValidPlacement(List<Integer> colPlacement) {
        int rowId = colPlacement.size() - 1;
        for (int i = 0; i < rowId; i++) {
            int diff = Math.abs(colPlacement.get(i) - colPlacement.get(rowId));
            if (diff == 0 || diff == rowId - i) return false;
        }
        return true;
    }

    private List<String> constructRes(List<Integer> res) {
        List<String> place = new ArrayList<>();
        for (int index : res) {
            StringBuilder row = new StringBuilder();
            for (int i = 0; i < res.size(); i++) {
                if (i == index) {
                    row.append("Q");
                } else {
                    row.append(".");
                }
            }
            place.add(row.toString());
        }
        return place;
    }
}
