package DataStructure;

public class Trie {

    TrieNode root = new TrieNode();

    static class TrieNode {
        TrieNode[] children;
        boolean isEndWord;

        TrieNode(){
            children = new TrieNode[26];
            isEndWord = false;
        }
    }

    public void insert(String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(node.children[c-'a'] == null){
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.isEndWord = true;
    }

    public boolean search(String word){
        TrieNode node = searchPrefix(word);
        return node != null && node.isEndWord;
    }

    public boolean startWith(String prefix){
        return searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(String prefix){
        TrieNode node = root;
        for(char c : prefix.toCharArray()){
            if(node.children[c-'a'] == null){
                return null;
            }
            node = node.children[c-'a'];
        }
        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        System.out.println("hell startWith: " + trie.startWith("hell"));
        System.out.println("hello startWith: " + trie.startWith("hello"));
        System.out.println("helloo startWith: " + trie.startWith("helloo"));
        System.out.println("hell search: " + trie.search("hell"));
        System.out.println("hello search: " + trie.search("hello"));
    }
}
