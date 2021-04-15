package trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    char c;
    Map<Character, TrieNode> children;
    boolean isLeaf;

    TrieNode() {
    }

    TrieNode(char c) {
        this.c = c;
        children = new HashMap<>();
    }
}
