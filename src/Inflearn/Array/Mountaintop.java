package Inflearn.Array;

import java.util.Scanner;

public class Mountaintop {
    int[] mX = {-1, 1, 0, 0};
    int[] mY = {0, 0, -1, 1};

    public int Solve(int n, int[][] arr){
        int answer = 0;

        for(int i=0; i<n ;i++){
            for(int j=0; j<n; j++){
                boolean flag = true;
                for(int k=0; k<4; k++){
                    int nx = i+mX[k];
                    int ny = j+mY[k];
                    if(nx >= 0 && nx < n && ny >=0 && ny < n &&arr[nx][ny] >= arr[i][j]){
                        flag = false;
                        break;
                    }
                }
                if(flag) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Mountaintop T = new Mountaintop();

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int arr[][] = new int[num][num];
        for(int i=0; i<num; i++){
            for (int j=0; j<num; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(T.Solve(num, arr));
    }
}
