package stack;

import java.util.Stack;

/*

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:
Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and
there won't be any divide by zero operation.

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
* */
public class EvaluateReversePolishNotation {
    private int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        String operators = "+-*/";

        int i = 0;
        int num;

        while (i < tokens.length) {
            if (!operators.contains(tokens[i])) {
                stack.push(Integer.valueOf(tokens[i]));
            } else {
                num = stack.pop();
                switch (tokens[i]) {
                    case "+":
                        num = stack.pop() + num;
                        stack.push(num);
                        break;
                    case "-":
                        num = stack.pop() - num;
                        stack.push(num);
                        break;
                    case "/":
                        num = stack.pop() / num;
                        stack.push(num);
                        break;
                    default:
                        num = stack.pop() * num;
                        stack.push(num);
                        break;
                }
            }

            i++;
        }

        return stack.peek();
    }

    public static void main(String[] args) {
        String[] tokens1 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new EvaluateReversePolishNotation().evalRPN(tokens1));

        String[] tokens2 = {"10", "6"};
        System.out.println(new EvaluateReversePolishNotation().evalRPN(tokens2));
    }
}
