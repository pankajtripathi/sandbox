package trees;

/*You need to construct a binary tree from a string consisting of parenthesis and integers.
The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis.
The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.
You always start to construct the left child node of the parent first if it exists.
* */
public class ConstructBinaryTreeFromString {
    public static void main(String[] args) {
        System.out.println(new BinaryTreeBFSWithQueue().bfs(new ConstructBinaryTreeFromString().str2tree("4(2(3)(1))(6(5))")));
    }

    int i = 0;
    public Node str2tree(String s) {
        if (s == null || s.length() == 0) return null;
        int start = i;

        while (i < s.length() && (s.charAt(i) == '-' || Character.isDigit(s.charAt(i)))) i++;
        Node node = new Node(Integer.parseInt(s.substring(start, i)));

        while (i != s.length()) {
            if (s.charAt(i) == ')') {
                i++;
                return node;
            }
            if (s.charAt(i) == '(') {
                i++;
                if (node.left == null)
                    node.left = str2tree(s);
                else node.right = str2tree(s);
            }
        }
        return node;
    }
}
