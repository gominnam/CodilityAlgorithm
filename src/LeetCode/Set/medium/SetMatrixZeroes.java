package LeetCode.Set.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        Set<Integer> setX = new HashSet<>();
        Set<Integer> setY = new HashSet<>();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    setY.add(i);
                    setX.add(j);
                }
            }
        }

        for(Integer x : setX) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][x] = 0;
            }
        }

        for(Integer y : setY){
            Arrays.fill(matrix[y], 0);
        }
    }

    public void setZeroes_2(int[][] matrix) {
        boolean r0 = false, c0 = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                c0 = true;
                break;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                r0 = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0]== 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (r0) for (int i = 0; i < matrix[0].length; i++) matrix[0][i] = 0;
        if (c0) for (int i = 0; i < matrix.length; i++) matrix[i][0] = 0;
    }

    public static void main(String[] args) {
        SetMatrixZeroes o = new SetMatrixZeroes();
        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        o.setZeroes(matrix);
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}

/*

Thinking:

- Set 자료구조를 통해 x축 y축 값을 저장하여 배열에 0 값 업데이트 방법으로 해결
- setZeroes_2 메소드는 추가적인 공간을 사용하지 않고 해결하는 방법
  + 0번째 행과 열을 축으로 삼아 각 행과 열에 0이 있는지 확인하여 업데이트

-ref: https://leetcode.com/problems/set-matrix-zeroes/

 */