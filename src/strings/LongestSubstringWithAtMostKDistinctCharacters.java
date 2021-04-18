package strings;

import java.util.HashMap;
import java.util.Map;

/*
* Given a string s and an integer k, return the length of the longest substring of s that contains at
* most k distinct characters.

Example 1:
Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.

Example 2:
Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.
* */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithAtMostKDistinctCharacters()
                .lengthOfLongestSubstringKDistinct("eceba", 2));
        System.out.println(new LongestSubstringWithAtMostKDistinctCharacters()
                .lengthOfLongestSubstringKDistinct("ccaabbb", 2));
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int start = 0;
        int end = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            end++;

            while (map.size() > k) {
                char temp = s.charAt(start);
                map.put(temp, map.get(temp) - 1);
                if (map.get(temp) == 0) map.remove(temp);
                start++;
            }

            max = Math.max(max, end - start);
        }
        return max;
    }
}
