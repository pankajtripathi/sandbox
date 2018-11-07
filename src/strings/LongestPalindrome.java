package strings;

import java.util.HashMap;

public class LongestPalindrome {
    public static void main(String[] args) {
        String str = "abccccdd";
        System.out.println(new LongestPalindrome().longestPalindrome(str));
    }

    private int longestPalindrome(String s) {
        HashMap map = new HashMap();

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.remove(s.charAt(i));
                count++;
            } else {
                map.put(s.charAt(i), (int)s.charAt(i));
            }
        }

        return map.isEmpty() ? count * 2 : count * 2 + 1;
    }
}
