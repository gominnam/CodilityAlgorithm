package LeetCode.HashTable.medium;

import java.util.HashMap;
import java.util.Map;

public class ImplementTrie {

//    class TrieNode {
//        Map<Character, TrieNode> children;
//        boolean isEndOfWord;
//
//        public TrieNode() {
//            children = new HashMap<>();
//            isEndOfWord = false;
//        }
//    }
//
//    private TrieNode root;
//
//    public ImplementTrie() {
//        root = new TrieNode();
//    }
//
//    public void insert(String word) {
//        TrieNode node = root;
//        for(char c : word.toCharArray()){
//            node.children.putIfAbsent(c, new TrieNode());
//            node = node.children.get(c);
//        }
//        node.isEndOfWord = true;
//    }
//
//    public boolean search(String word) {
//        TrieNode node = root;
//        for(char c : word.toCharArray()){
//            node = node.children.get(c);
//            if(node == null){
//                return false;
//            }
//        }
//        return node.isEndOfWord;
//    }
//
//    public boolean startsWith(String prefix) {
//        TrieNode node = root;
//        for(char c : prefix.toCharArray()){
//            node = node.children.get(c);
//            if(node == null){
//                return false;
//            }
//        }
//        return true;
//    }

    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26]; // 알파벳 소문자만 다룰 경우
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            node = node.children[index];
            if (node == null) {
                return false;
            }
        }
        return node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            node = node.children[index];
            if (node == null) {
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

Thinking:
: HashTable 자료구조처럼 Array를 사용하여 최적화를 구현. // Map -> Array

-ref: https://leetcode.com/problems/implement-trie-prefix-tree/description/

 */
