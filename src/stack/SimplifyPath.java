package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/home/";
        System.out.println(new SimplifyPath().simplifyPath(path));
    }

    private String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        // if first string is parent directory
        if (path.startsWith("/")) stack.addFirst("/");

        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (dir.equals("..")) {
                // if stack is empty or first element is .. then just add dir
                if (stack.isEmpty() || stack.peekFirst().equals("..")) {
                    stack.addFirst(dir);

                    // if first is parent directory and now we see .. then continue or throw error as you cannot go up
                } else if (stack.peekFirst().equals("/")){
                    continue;
                }

                stack.removeFirst();
            } else if (!dir.equals(".") && !dir.isEmpty()) {
                // if not . and not empty add to stack
                stack.addFirst(dir);
            }
        }

        Iterator<String> it = stack.descendingIterator();
        StringBuilder result = new StringBuilder();
        String prev = it.next();
        result.append(prev);

        while (it.hasNext()) {
            if (!prev.equals("/")) {
                result.append("/");
            }

            prev = it.next();
            result.append(prev);
        }

        return result.toString();
    }
}
