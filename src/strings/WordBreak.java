package strings;

import java.util.*;

public class WordBreak {
    Map<Integer, List<String>> map = new HashMap<>();

    public static void main(String[] args) {
        String[] words = {"cat", "cats", "and", "sand", "dog"};
        List<String> wordDict = Arrays.asList(words);
        String s = "catsanddog";

        System.out.println(new WordBreak().wordBreak(s, wordDict));

        System.out.println(new WordBreak().isWordBreakPossible(s, wordDict));
    }

    /*
    Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be
    segmented into a space-separated sequence of one or more dictionary words.

    Note:
    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.

    Example 1:
    Input: s = "leetcode", wordDict = ["leet", "code"]
    Output: true
    Explanation: Return true because "leetcode" can be segmented as "leet code".
    * */
    private boolean isWordBreakPossible(String s, List<String> wordDict) {
        return isWordBreakPossibleHelper(s, wordDict, 0, new Boolean[s.length()]);
    }

    private boolean isWordBreakPossibleHelper(String s, List<String> wordDict, int start, Boolean[] check) {
        // if end reached then return true
        if (s.length() == start) return true;

        // if start is seen before then return the bool value
        if (check[start] != null) return check[start];

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && isWordBreakPossibleHelper(s, wordDict, end, check)) {
                return check[start] = true;
            }
        }

        // since dictionary doesn't contain the word set it to false
        return check[start] = false;
    }


    /*
    Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s
    to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

    Note:
    The same word in the dictionary may be reused multiple times in the segmentation.
    You may assume the dictionary does not contain duplicate words.

    Example 1:
    Input:
    s = "catsanddog"
    wordDict = ["cat", "cats", "and", "sand", "dog"]
    Output:
    [
    "cats and dog",
    "cat sand dog"
    ]
    * */
    private List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s, wordDict, 0);
    }

    private List<String> wordBreakHelper(String s, List<String> wordDict, int start) {
        List<String> result = new ArrayList<>();

        if (map.containsKey(start)) {
            return map.get(start);
        }

        if (s.length() == start) {
            result.add("");
        }

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> nextList = wordBreakHelper(s, wordDict, end);
                for (String next : nextList) {
                    result.add(s.substring(start, end) + (next.equals("") ? "" : " ") + next);
                }
            }
        }

        map.put(start, result);
        return result;
    }
}
