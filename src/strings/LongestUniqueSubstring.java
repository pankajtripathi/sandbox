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

        System.out.println(new LongestUniqueSubstring().getLongestUniqueSubstring(str1));
        System.out.println(new LongestUniqueSubstring().getLongestUniqueSubstring(str2));
        System.out.println(new LongestUniqueSubstring().getLongestUniqueSubstring(str3));
    }

    private int getLength(String str) {
        if (str == null || str.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();

        int max = 0;
        for (int i = 0, right = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                right = Math.max(right, map.get(c) + 1);
            }
            map.put(c, i);

            max = Math.max(max, i - right + 1);
        }

        return max;
    }

    private int getLongestUniqueSubstring(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, len = 0, counter = 0;

        while (end < str.length()) {
            char c = str.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > 1) counter++;
            end++;

            while (counter > 0) {
                char tempC = str.charAt(start);
                if (map.get(tempC) > 1) counter--;
                map.put(tempC, map.get(tempC) - 1);
                start++;
            }

            len = Math.max(len, end - start);
        }

        return len;
    }
}
