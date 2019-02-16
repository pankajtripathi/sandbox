package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TowerOfHanoi {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();

        int numOfRings = 6;
        int numOfPegs = 3;

        List<Stack<Integer>> pegs = new ArrayList<>();
        for (int i = 0; i < numOfPegs; i++) {
            pegs.add(i, new Stack<>());
        }

        for (int i = numOfRings; i >= 1; i--) {
            pegs.get(0).push(i);
        }

        new TowerOfHanoi().countSteps(numOfRings, pegs, 0, 1, 2, result);
        System.out.println(result);
    }

    private void countSteps(int numOfRingsToMove,
                            List<Stack<Integer>> pegs,
                            int from,
                            int to,
                            int use,
                            List<List<Integer>> result) {
        if (numOfRingsToMove > 0) {
            countSteps(numOfRingsToMove - 1, pegs, from, use, to, result);
            pegs.get(to).push(pegs.get(from).pop());
            result.add(Arrays.asList(from, to));
            countSteps(numOfRingsToMove - 1, pegs, use, to, from, result);
        }
    }
}
