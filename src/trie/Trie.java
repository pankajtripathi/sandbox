package design;

import design.TrieNode;

import java.util.Map;

public class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    public boolean search(String word) {
        TrieNode node = searchNode(word);
        // word exists only if it's not null and leaf node
        return node != null && node.isLeaf;
    }

    private TrieNode searchNode(String word) {
        TrieNode current = null;
        Map<Character, TrieNode> children = root.children;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!children.containsKey(c)) {
                return null;
            } else {
                current = children.get(c);
                children = current.children;
            }
        }
        return current;
    }

    public void insert(String word) {
        // get children of root
        Map<Character, TrieNode> children = root.children;

        for (int i = 0; i < word.length(); i++) {
            // get char and check if it exists in the children map
            // if it does then current is children.get(c) => TrieNode with that char
            // else create a new TrieNode and put that in root children map
            // children = current.children and keep looking for other chars in the word
            char c = word.charAt(i);
            TrieNode current = null;

            if (children.containsKey(c)) {
                current = children.get(c);
            } else {
                current = new TrieNode(c);
                children.put(c, current);
            }

            children = current.children;

            if (i == word.length() - 1) current.isLeaf = true;
        }
    }
}
