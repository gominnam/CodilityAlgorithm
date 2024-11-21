package LeetCode.Array.medium;

import java.util.Arrays;

public class RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    public void rotateLeft(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = temp;
            }
        }
    }

    public static void main(String[] args){
        RotateImage ri = new RotateImage();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        ri.rotate(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();

        ri.rotateLeft(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}

/*

Thinking:

- right rotate인 경우

: (2, 0) -> (0, 0) -> (0, 2) -> (2, 2) -> (2, 0)
: (x, y) 일 경우 회전하고나면 y -> x, (n - x - 1) -> y
  즉, (x,y) -> (y, n-x-1)) 이동한다.


-ref: https://leetcode.com/problems/rotate-image/submissions

 */
