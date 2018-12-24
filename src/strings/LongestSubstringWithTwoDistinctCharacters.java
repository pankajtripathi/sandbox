package strings;

import java.util.HashMap;
import java.util.Map;

/*
Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:
Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.

Example 2:
Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
* */
public class LongestSubstringWithTwoDistinctCharacters {
    public static void main(String[] args) {
        String str1 = "eceba";
        String str2 = "ccaabbb";

        System.out.println(new LongestSubstringWithTwoDistinctCharacters().lengthOfLongestSubstringTwoDistinct(str1));
        System.out.println(new LongestSubstringWithTwoDistinctCharacters().lengthOfLongestSubstringTwoDistinct(str2));
    }

    private int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        int max = 0;
        int start = 0;
        int end = 0;
        int counter = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) counter++; // new char
            end++;

            while (counter > 2) {
                char tempC = s.charAt(start);
                map.put(tempC, map.get(tempC) - 1);
                if (map.get(tempC) == 0) counter--;
                start++;
            }

            max = Math.max(max, end - start);
        }

        return max;
    }
}
