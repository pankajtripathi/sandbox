package strings;

import java.util.HashMap;
import java.util.Map;

/*
* Given a string, find the length of the longest substring without repeating characters. 
* For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
* For "bbbbb" the longest substring is "b", with the length of 1.
* */
public class LongestUniqueSubstring {
    public static void main(String[] args) {
        String str1 = "pwwkew";
        String str2 = "abcabcbb";
        String str3 = "bbbbb";

        System.out.println(new LongestUniqueSubstring().getLength(str1));
        System.out.println(new LongestUniqueSubstring().getLength(str2));
        System.out.println(new LongestUniqueSubstring().getLength(str3));
    }

    private int getLength(String str) {
        if (str == null || str.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap();

        int max = 0;
        for (int i = 0, count = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                count = Math.max(count, map.get(c) + 1);
            }
            map.put(c, i);

            max = Math.max(max, i - count + 1);
        }

        return max;
    }
}
