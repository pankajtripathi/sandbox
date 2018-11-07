package strings;

public class PalindromicSubstrings {
    int result = 0;

    public static void main(String[] args) {
        String str = "aaa";
        System.out.println(new PalindromicSubstrings().countSubstrings(str));
    }

    private int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        for (int i = 0; i < s.length(); i++) {
            getSubstring(s, i, i);
            getSubstring(s, i, i + 1);
        }

        return result;
    }

    private void getSubstring(String str, int start, int end) {
        while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            result++;
            end++;
            start--;
        }
    }
}
