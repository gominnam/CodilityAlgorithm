package LeetCode.HashTable.medium;

import java.util.HashMap;
import java.util.Map;

public class ImplementTrie {

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            node = node.children.get(c);
            if(node == null){
                return false;
            }
        }
        return node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char c : prefix.toCharArray()){
            node = node.children.get(c);
            if(node == null){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        ImplementTrie trie = new ImplementTrie();
        trie.insert("apple");
        trie.search("apple");   // return True
        trie.search("app");     // return False
        trie.startsWith("app"); // return True
        trie.insert("app");
        trie.search("app");     // return True
    }
}

/*

-ref: https://leetcode.com/problems/implement-trie-prefix-tree/description/

 */
