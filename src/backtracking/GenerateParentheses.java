package backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
* */
public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
        System.out.println(new GenerateParentheses().generateParenthesis(1));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        paranthesis(n, n, "", result);
        return result;
    }

    public void paranthesis(int leftParanthesis, int rightParanthesis, String temp, List<String> result) {
        // No ")" to add
        if (rightParanthesis == 0) {
            result.add(temp);
            return;
        }

        // "(" can be added
        if (leftParanthesis > 0) paranthesis(leftParanthesis - 1, rightParanthesis, temp + "(", result);

        // ")" can be added
        if (rightParanthesis > leftParanthesis) paranthesis(leftParanthesis, rightParanthesis - 1, temp + ")", result);
    }
}
