package stack;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(4);

        System.out.println(new SortStack().sort(stack));
    }

    private Stack<Integer> sort(Stack<Integer> stack) {
        if (stack == null || stack.size() == 0) return stack;
        Stack<Integer> newStack = new Stack<>();
        newStack.push(stack.pop()); // store top in new stack

        while (!stack.empty()) {
            int temp = stack.pop();

            // if top of stack is greater than the current top of newStack then add top of newStack to stack
            // and temp to new stack
            while (!newStack.empty() && temp > newStack.peek()) {
                stack.push(newStack.pop());
            }

            newStack.push(temp);
        }

        return newStack;
    }
}
