package graphs;

import java.util.*;

/*
* There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.
* You are given a list of strings words from the alien language's dictionary, where the strings in words are sorted
* lexicographically by the rules of this new language.

* Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new
* language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.

* A string s is lexicographically smaller than a string t if at the first letter where they differ, the letter in
* s comes before the letter in t in the alien language. If the first min(s.length, t.length) letters are the same,
* then s is smaller if and only if s.length < t.length.
Example 1:
Input: words = ["wrt","wrf","er","ett","rftt"]
Output: "wertf"

Example 2:
Input: words = ["z","x"]
Output: "zx"

Example 3:
Input: words = ["z","x","z"]
Output: ""
Explanation: The order is invalid, so return "".
* Question is similar to course schedule only difference is condition when constructing graph
* */
public class AlienDictionary {
    Map<Character, Set<Character>> graph = new HashMap<>();
    Stack<Character> stack = new Stack<>();
    int[] visited = new int[256];
    boolean firstLetterDiffers = false;

    public static void main(String[] args) {
        String[] words1 = {"wrt","wrf","er","ett","rftt"};
        String[] words2 = {"z","x","z"};
        AlienDictionary obj = new AlienDictionary();
        System.out.println(obj.alienOrder(words1));
        System.out.println(obj.alienOrder(words2));
    }

    public String alienOrder(String[] words) {
        String result = "";
        if (words == null || words.length == 0) return result;

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i+1];
            int minLen = Math.min(w1.length(), w2.length());

            if (w1.length() > w2.length() && w1.startsWith(w2)) return result;

            for (int j = 0; j < minLen; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if (!graph.containsKey(c1)) graph.put(c1, new HashSet<>());
                if (!graph.containsKey(c2)) graph.put(c2, new HashSet<>());

                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    firstLetterDiffers = true;
                    break;
                }
            }
        }

        for(String word: words){
            for(Character c: word.toCharArray()){
                if(!graph.containsKey(c)) graph.put(c, new HashSet<>());
            }
        }

        for (Character source : graph.keySet()) {
            if (isCyclic(source, visited)) return result;
        }

        while (!stack.isEmpty()) result += stack.pop();
        return result;
    }

    private boolean isCyclic(Character u, int[] visited){
        if(visited[u-'a']==-1) return true;
        if(visited[u-'a']==1) return false;

        visited[u-'a'] = -1;
        if(graph.containsKey(u)){
            for(Character v:graph.get(u))
                if(isCyclic(v, visited)) return true;
        }

        visited[u-'a'] = 1;
        stack.push(u);
        return false;
    }
}
