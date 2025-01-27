package LeetCode.BackTracking.medium;

public class WordSearch {

    int[][] mv = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && backtracking(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, String word, int depth, int x, int y) {
        if (depth == word.length()) return true;

        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != word.charAt(depth)) return false;

        char temp = board[x][y];
        board[x][y] = '#';

        for (int[] move : mv) {
            int nx = x + move[0];
            int ny = y + move[1];
            if (backtracking(board, word, depth + 1, nx, ny)) return true;
        }

        board[x][y] = temp;
        return false;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        System.out.println(wordSearch.exist(board, "ABCCED")); // true
//        System.out.println(wordSearch.exist(board, "SEE")); // true
//        System.out.println(wordSearch.exist(board, "ABCB")); // false
    }
}

/*

Thinking:
- backTracking 문제로 해결
- refactoring 처음에는 boolean[][] cache 메모리를 사용 했지만, board를 활용하여 메모리 최적화


-ref: https://leetcode.com/problems/word-search/

 */