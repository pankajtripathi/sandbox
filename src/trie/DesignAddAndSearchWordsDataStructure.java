package trie;

import java.util.HashMap;
import java.util.Map;

class DesignAddAndSearchWordsDataStructure {
    TrieNode root;
    public DesignAddAndSearchWordsDataStructure() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        insert(word);
    }

    public boolean search(String word) {
        return searchNode(word, root);
    }

    // check if children contains that character if not check for '.'
    // in case of '.' loop through each child node with next string
    // otherwise return false
    // if it contains then update node reference
    public boolean searchNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                if (c == '.') {
                    for (char ch : node.children.keySet()) {
                        TrieNode childNode = node.children.get(ch);
                        if (searchNode(word.substring(i + 1), childNode))
                            return true;
                    }
                }
                return false;
            } else  {
                node = node.children.get(c);
            }
        }
        return node.isLeaf;
    }

    // check if node children has that character if not add it to the children map
    // get the node reference
    // At the end mark it as leaf node
    public void insert(String word) {
        TrieNode node = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isLeaf = true;
    }

    class TrieNode {
        boolean isLeaf = false;
        Map<Character, TrieNode> children = new HashMap<>();
        TrieNode() {}
    }

    public static void main(String[] args) {
        DesignAddAndSearchWordsDataStructure wordDictionary = new DesignAddAndSearchWordsDataStructure();
        wordDictionary.addWord("a");
        wordDictionary.addWord("a");
        System.out.println(wordDictionary.search(".")); // return True
        System.out.println(wordDictionary.search("a")); // return True
        System.out.println(wordDictionary.search("aa")); // return false
        System.out.println(wordDictionary.search("a")); // return True
        System.out.println(wordDictionary.search(".a")); // return False
        System.out.println(wordDictionary.search("a.")); // return False
    }
}
