package strings;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String str = "the sky is blue";
        System.out.println(new ReverseWordsInAString().reverse(str));
    }

    // \\s+ matches multiple whitespace characters
    // \\s matches single whitespace character
    private String reverse(String str) {
        if (str == null || str.length() == 0) return str;
        String[] strs = str.trim().split("\\s+");

        String res = "";
        for (int i = strs.length - 1; i >= 0; i--) {
            res += strs[i] + " ";
        }

        return res;
    }
}
