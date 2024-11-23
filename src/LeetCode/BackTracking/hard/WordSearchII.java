package LeetCode.BackTracking.hard;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    public final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    TrieNode root = new TrieNode();

    public class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEndOfWord = true;
        }
    }

    public boolean startsWith(String prefix){
        TrieNode node = root;
        for(char c : prefix.toCharArray()){
            int idx = c - 'a';
            if(node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return true;
    }

    public void TrieInit(char[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                boolean[][] cache = new boolean[board.length][board[0].length];
                cache[i][j] = true;
                int idx = board[i][j] - 'a';
                if(root.children[idx] == null){
                    root.children[idx] = new TrieNode();
                }
                dfs(board, new int[]{i, j}, cache, root.children[idx]);
            }
        }
    }

    public void dfs(char[][] board, int[] cur, boolean[][] cache, TrieNode node){
        int xn = board.length;
        int yn = board[0].length;
        for(int[] dir : DIRECTIONS){
            int mx = cur[0] + dir[0];
            int my = cur[1] + dir[1];
            if(mx >= 0 && my >= 0 && mx < xn && my < yn && !cache[mx][my]){
                int idx = board[mx][my] - 'a';
                if(node.children[idx] == null){
                    node.children[idx] = new TrieNode();
                }
                cache[mx][my] = true;
                dfs(board, new int[]{mx, my}, cache, node.children[idx]);
                cache[mx][my] = false;
            }
        }
    }


    public List<String> findWords(char[][] board, String[] words) {
        TrieInit(board);
        List<String> result = new ArrayList<>();
        for(String word : words){
            if(startsWith(word)) {
                result.add(word);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        WordSearchII ws = new WordSearchII();
//        char[][] board = {
//                {'o', 'a', 'a', 'n'},
//                {'e', 't', 'a', 'e'},
//                {'i', 'h', 'k', 'r'},
//                {'i', 'f', 'l', 'v'}
//        };
//        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = {{'a', 'b'}};
        String[] words = {"ab"};
        System.out.println(ws.findWords(board, words));
    }
}

/*

Thinking:
- 처음에 bfs로 접근했지만 bfs는 중간에 chaining이 끊겨 Trie 접근이 안된다고 판단하여 dfs로 수정
- 꼭 정사각형만 있는 것이 아니라 직사각형도 가능. 따라서 xn, yn을 따로 수정
- Time Limit Exceeded 발생

-ref: https://leetcTrieNode.com/problems/word-search-ii/description/

 */