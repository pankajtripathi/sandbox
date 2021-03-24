package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/home/";
        System.out.println(new SimplifyPath().simplifyPath(path));
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] dirs = path.split("/");
        
        for (String dir: dirs) {
            if (dir.equals("..")) {
                // if stack is empty or first element is .. then just add dir
                if (stack.isEmpty() || stack.peek().equals(".."))
                    stack.add("..");
                // if first is parent directory and now we see .. then continue or throw error as you cannot go up
                else if (stack.peek().equals("/"))
                    continue;
                stack.pop();
            } else if (!dir.isEmpty() && !dir.equals(".")) {
                // if not . and not empty add to stack
                stack.add(dir);
            }
        }
        
        StringBuilder res = new StringBuilder();
        for (String item: stack) {
            res.append("/");
            res.append(item);
        }
        
        return res.length() > 0 ? res.toString() : "/";
    }
}
