package LeetCode.BackTracking.medium;

public class WordSearch {

    boolean[][] cache;
    int[][] mv = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                boolean isTrue = false;
                if(board[i][j] == word.charAt(0)){
                    cache = new boolean[m][n]; // current position
                    int[] cur = {i, j};
                    cache[i][j] = true;
                    isTrue = backTracking(board, word, 1, cur);
                }
                if(isTrue) return true;
            }
        }

        return false;
    }

    public boolean backTracking(char[][] board, String word, int depth, int[] current){
        if(depth == word.length()) return true;
        for(int i=0; i<4; i++){
            int nx = current[0] + mv[i][0];
            int ny = current[1] + mv[i][1];
            if(nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length || cache[nx][ny] || board[nx][ny] != word.charAt(depth)) continue;
            cache[nx][ny] = true;
            if(backTracking(board, word, depth+1, new int[] {nx, ny})) return true;
            cache[nx][ny] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        System.out.println(wordSearch.exist(board, "ABCCED")); // true
        System.out.println(wordSearch.exist(board, "SEE")); // true
        System.out.println(wordSearch.exist(board, "ABCB")); // false
    }
}

/*

Thinking:
- backTracking 문제로 해결


-ref: https://leetcode.com/problems/word-search/

 */