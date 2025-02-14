package LeetCode.Array.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    final static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // right, down, left, up
    List<Integer> result = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        int idx = 0;
        int[] cur = {0, 0};
        while(result.size() < (matrix.length * matrix[0].length)){
            cur = spiralMatrix(matrix, cur, direction[idx]);
            idx = (idx + 1) % 4;
        }

        return result;
    }

    public int[] spiralMatrix(int[][] matrix, int[] cur, int[] dir){
        if(matrix[cur[0]][cur[1]] == Integer.MIN_VALUE){
            cur[0] += dir[0];
            cur[1] += dir[1];
        }

        while(cur[0] < matrix.length && cur[1] < matrix[0].length && cur[0] >= 0 && cur[1] >= 0
        && matrix[cur[0]][cur[1]] != Integer.MIN_VALUE){
            int y = cur[0];
            int x = cur[1];
            result.add(matrix[y][x]);
            matrix[y][x] = Integer.MIN_VALUE;
            cur[0] += dir[0];
            cur[1] += dir[1];
        }
        cur[0] -= dir[0];
        cur[1] -= dir[1];
        return cur;
    }

    public List<Integer> spiralOrder_array(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int row = 0, col = 0, dirIdx = 0;

        for (int i = 0; i < rows * cols; i++) {
            result.add(matrix[row][col]);
            visited[row][col] = true;
            int nextRow = row + direction[dirIdx][0];
            int nextCol = col + direction[dirIdx][1];

            if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && !visited[nextRow][nextCol]) {
                row = nextRow;
                col = nextCol;
            } else {
                dirIdx = (dirIdx + 1) % 4;
                row += direction[dirIdx][0];
                col += direction[dirIdx][1];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix3 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(sm.spiralOrder(matrix)); // [1, 2, 3, 6, 9, 8, 7, 4, 5]
        System.out.println(sm.spiralOrder_array(matrix2)); // [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
        System.out.println(sm.spiralOrder_array( matrix3)); // [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
    }
}

/*

Thinking:
- 방향을 갖는 배열 direction을 만들어서 방향을 바꿔가면서 순회
- 메모리 효율성을 위해 matrix 값을 Integer.MIN_VALUE로 변경하여 체크

- spiralOrder_array()
    - 배열 index 값을 구하는 방식으로 하나하나 add 하는 방법 (직관적)

-ref: https://leetcode.com/problems/spiral-matrix/

 */
