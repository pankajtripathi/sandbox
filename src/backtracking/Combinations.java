package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
You may return the answer in any order.

Example 1:
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

Example 2:
Input: n = 1, k = 1
Output: [[1]]
* */
public class Combinations {
    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4, 2));
        System.out.println(new Combinations().combine(1, 1));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combinations(n, k, new ArrayList<>(), result, 1);
        return result;
    }

    // Similar to permutations except we need to keep track of start
    public void combinations(int n, int k, List<Integer> temp, List<List<Integer>> result, int start) {
        if (temp.size() == k) result.add(new ArrayList<>(temp));
        else {
            for (int i = start; i <= n; i++) {
                if (temp.contains(i)) continue;

                temp.add(i);

                combinations(n, k, temp, result, i + 1);

                temp.remove(temp.size() - 1);
            }
        }
    }
}

