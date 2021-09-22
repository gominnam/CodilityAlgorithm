package BaekJoon.DFS_BFS;

import java.io.*;
import java.util.*;

public class D_2580 {
    public static int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<9; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0, 0);
    }

    public static void sudoku(int row, int col){
        //해당 행이 다 채워질 경우 다음열의 0번째 행부터 시
        if(col == 9){
            sudoku(row+1, 0);
            return;
        }

        //행과 열이 다 채워질 경우 출력 후 종료
        if(row == 9){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    sb.append(arr[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            //출력 뒤 시스템을 종료한다.
            System.exit(0);
        }

        //만약 해당 위치가 0이라면 1부터 9까지 중 가능한 수 탐색
        if(arr[row][col] == 0){
            for(int i=1; i<=9; i++){
                //i값 중복 확인
                if(isPossible(row, col, i)){
                    arr[row][col] = i;
                    sudoku(row, col+1);
                }
            }
            arr[row][col] = 0;//숫자를 넣은 경우 중복 숫자가 있을 경우 롤백
            return;
        }

        sudoku(row, col+1);
    }

    public static boolean isPossible(int row, int col, int val){
        //같은 행에 같은 숫자가 있는지 확인
        for(int i=0; i<9; i++){
            if(arr[row][i] == val) return false;
        }

        //같은 열에 같은 숫자가 있는지 확인
        for(int i=0; i<9; i++){
            if(arr[i][col] == val) return false;
        }

        //3*3에 중복 숫자가 있는지 check
        int set_row = (row / 3) * 3;
        int set_col = (col / 3) * 3;

        for(int i=set_row; i<set_row+3; i++){
            for(int j=set_col; j<set_col+3; j++){
                if(arr[i][j] == val) return false;
            }
        }

        return true;
    }
}
/*
스토쿠 문제

TIP - Backtracking

1. 같은 열 기준 숫자가 겹치는지 검사
2. 같은 행 기준 숫자가 겹치는지 검사
3. 3x3 정사각형 안에 숫자가 겹치는지 검사


 */