package strings;

import java.util.*;

/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0
* */
class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";

        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        // System.out.println(new WordLadder().ladderLength(beginWord, endWord, wordList));
        System.out.println(new WordLadder().findLadders(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) return 0;

        Set<String> visited = new HashSet<>();

        Queue<Vertex> queue = new LinkedList<>();
        Vertex start = new Vertex(beginWord, 1);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex current = queue.poll();

            // for each word in dict check if it's neighbor (i.e. diff equal to 1)
            for (String word : wordList) {
                if (isAdjacent(current.word, word)) {
                    Vertex neighbor = new Vertex(word, current.len + 1);
                    queue.add(neighbor);
                    visited.add(word);

                    if (endWord.equals(neighbor.word)) {
                        return neighbor.len;
                    }
                }
            }

            // remove visited vertices from dict
            wordList.removeAll(visited);
        }

        return 0;
    }

    // check if diff between strings is less or equal to one
    private boolean isAdjacent(String p, String q) {
        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != q.charAt(i)) {
                count++;
            }

            if (count > 1) return false;
        }

        return true;
    }

    // class to keep track of word and it's diff from beginWord
    class Vertex {
        String word;
        int len;

        Vertex(String word, int len) {
            this.word = word;
            this.len = len;
        }
    }

    // Difference in both question is that here we need queue of list of words that lead to endWord
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (wordList == null || wordList.size() == 0)
            return result;
        // Create set of wordList
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);
        // Start by adding beginWord in the queue
        Queue<List<String>> queue = new ArrayDeque<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        queue.add(list);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> visited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                // Get last word from the path and see if it is equal to endWord
                List<String> currentPath = queue.poll();
                String current = currentPath.get(currentPath.size() - 1);
                if (current.equals(endWord)) {
                    result.add(currentPath);
                }
                // Create char array of last word and replace one character and see if it exists in the wordList
                for (int j = 0; j < current.length(); j++) {
                    char[] chars = current.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[j] = ch;
                        String word = new String(chars);
                        if (wordSet.contains(word)) {
                            List<String> updatedList = new ArrayList<>(currentPath);
                            updatedList.add(word);
                            visited.add(word);
                            queue.add(updatedList);
                        }
                    }
                }
            }

            wordSet.removeAll(visited);
        }
        return result;
    }
}
