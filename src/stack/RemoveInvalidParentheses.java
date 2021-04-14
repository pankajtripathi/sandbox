package stack;

import java.util.*;

/*
Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses
to make the input string valid.
Return all the possible results. You may return the answer in any order.

Example 1:
Input: s = "()())()"
Output: ["(())()","()()()"]

Example 2:
Input: s = "(a)())()"
Output: ["(a())()","(a)()()"]

Example 3:
Input: s = ")("
Output: [""]
* */
public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses("()())()"));
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses("(a)())()"));
        System.out.println(new RemoveInvalidParentheses().removeInvalidParentheses(")("));
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        bfs(s, result);
        return result;
    }

    public void bfs(String s, List<String> result) {
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        boolean found = false;

        queue.add(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (visited.contains(current)) continue;
                visited.add(current);
                if (isValid(current)) {
                    result.add(current);
                    found = true;
                }

                for (int j = 0; j < current.length(); j++) {
                    String next = current.substring(0, j) + current.substring(j + 1);
                    if (!visited.contains(next)) queue.add(next);
                }
            }
            if (found) return;
        }
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                stack.push(ch);
            else if (ch != ')')
                continue;
            else if (stack.isEmpty())
                return false;
            else {
                char pop = stack.pop();
                if (pop != '(') return false;
            }
        }
        return stack.isEmpty();
    }
}
