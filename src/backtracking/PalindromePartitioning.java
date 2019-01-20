package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new PalindromePartitioning().partition(s));
    }

    private List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;

        backtracking(s, new ArrayList<>(), result, 0);
        return result;
    }

    private void backtracking(String s, List<String> temp, List<List<String>> result, int start) {
        if (start == s.length()) result.add(new ArrayList<>(temp));
        else {
            for (int i = start; i < s.length(); i++) {
                String sub = s.substring(start, i + 1);
                if (isPalindrome(sub)) {
                    // choose
                    temp.add(sub);

                    //explore
                    backtracking(s, temp, result, i + 1);

                    //remove
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }
}
