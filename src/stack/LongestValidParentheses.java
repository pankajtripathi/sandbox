package stack;

import java.util.Stack;

/**
 * Input: str = "(()()"
 Initialize result as 0 and stack with one item -1.
 For i = 0, str[0] = '(', we push 0 in stack
 For i = 1, str[1] = '(', we push 1 in stack
 For i = 2, str[2] = ')', currently stack has [-1, 0, 1], we pop
 from the stack and the stack now is [-1, 0] and length of current
 valid substring becomes 2 (we get this 2 by subtracting stack top
 from current index).
 Since current length is more than current result, we update result.
 For i = 3, str[3] = '(', we push again, stack is [-1, 0, 3].
 For i = 4, str[4] = ')', we pop from the stack, stack becomes
 [-1, 0] and length of current valid substring becomes 4 (we get
 this 4 by subtracting stack top from current index).
 Since current length is more than current result, we update result.
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        String str1 = "((()()";
        findMaxLen(str1);
        String str2 = "()(()))))";
        findMaxLen(str2);
    }

    private static void findMaxLen(String str) {
        if (str.length() == 0) return;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }

                res = Math.max(res, i - stack.peek());
            }
        }

        System.out.println(res);
    }
 
 // In this approach, we make use of two counters leftleft and rightright. 
 // First, we start traversing the string from the left towards the right and for every \text{‘(’}‘(’ encountered, we increment the left
 // counter and for every \text{‘)’}‘)’ encountered, we increment the rightright counter. 
 // Whenever leftleft becomes equal to rightright, we calculate the length of the current valid string and keep track of maximum length substring found so far. 
 // If rightright becomes greater than leftleft we reset left and right to 0.

Next, we start traversing the string from right to left and similar procedure is applied.
 public int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            
            if (left == right) {
                max = Math.max(max, 2 * right);
            } else if (right >= left) {
                left = 0;
                right = 0;
            }
        }
        
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            
            if (left == right) {
                max = Math.max(max, 2 * left);
            } else if (left >= right) {
                left = 0;
                right = 0;
            }
        }
        
        return max;
    }

}
