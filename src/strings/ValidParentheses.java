package strings;

import java.util.Stack;

/*
* Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

* An input string is valid if:

* Open brackets must be closed by the same type of brackets.
* Open brackets must be closed in the correct order.
* Note that an empty string is also considered valid.
*/

public class ValidParentheses {
    public static void main(String[] args) {
        String str1 = "()[]{}";
        String str2 = "((";
        String str3 = "([)]";

        System.out.println(new ValidParentheses().isValid(str1));
        System.out.println(new ValidParentheses().isValid(str2));
        System.out.println(new ValidParentheses().isValid(str3));
    }


    private boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        if (s.length() < 2) return false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else if (!stack.isEmpty() && s.charAt(i) == ')' && stack.peek() == '(')
                stack.pop();
            else if (!stack.isEmpty() && s.charAt(i) == '}' && stack.peek() == '{')
                stack.pop();
            else if (!stack.isEmpty() && s.charAt(i) == ']' && stack.peek() == '[')
                stack.pop();
            else return false;
        }

        return stack.isEmpty();
    }
}
