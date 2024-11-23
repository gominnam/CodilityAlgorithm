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
            this.isEndOfWord = false;
        }
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEndOfWord = true;
    }

    public void dfs(char[][] board, int x, int y, TrieNode node, boolean[][] visited, StringBuilder sb, List<String> result) {
        if (node.isEndOfWord) {
            result.add(sb.toString());
            node.isEndOfWord = false; // 중복 방지
        }

        int xn = board.length;
        int yn = board[0].length;

        for (int[] dir : DIRECTIONS) {
            int mx = x + dir[0];
            int my = y + dir[1];
            if (mx >= 0 && my >= 0 && mx < xn && my < yn && !visited[mx][my]) {
                int idx = board[mx][my] - 'a';
                if (node.children[idx] != null) {
                    visited[mx][my] = true;
                    sb.append(board[mx][my]);
                    dfs(board, mx, my, node.children[idx], visited, sb, result);
                    sb.deleteCharAt(sb.length() - 1);
                    visited[mx][my] = false;
                }
            }
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            insert(word);
        }

        List<String> result = new ArrayList<>();
        int xn = board.length;
        int yn = board[0].length;
        boolean[][] visited = new boolean[xn][yn];

        for (int i = 0; i < xn; i++) {
            for (int j = 0; j < yn; j++) {
                int idx = board[i][j] - 'a';
                if (root.children[idx] != null) {
                    visited[i][j] = true;
                    dfs(board, i, j, root.children[idx], visited, new StringBuilder().append(board[i][j]), result);
                    visited[i][j] = false;
                }
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
  : 사고를 바꿔야 하는 문제.
  : board의 모든 문자를 Trie에 넣어서 시작하는 것이 아니라 Trie에 있는 문자로 시작하는 것만 찾아야 한다.


-ref: https://leetcTrieNode.com/problems/word-search-ii/description/

 */