package Inflearn.Array;

import java.util.Scanner;

public class TemporaryClass {
    public int Solve(int n, int[][] arr){
        int answer = 0;
        int max = 0;

        for(int i=0; i<n; i++){
            boolean check[] = new boolean[n];
            for(int j=0; j<5; j++){
                for(int k=0; k<n; k++){
                    if(check[k]) continue;
                    if(arr[i][j] == arr[k][j]) check[k] = true;
                }
            }
            int cnt = 0;
            for(int z=0; z<n; z++){
                if(check[z]) cnt++;
            }
            if(cnt > max) {
                max = cnt;
                answer = i+1;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        TemporaryClass T = new TemporaryClass();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][5];
        for(int i=0; i<n; i++){
            for(int j=0; j<5; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(T.Solve(n, arr));
    }
}

/*

    조건 잘 읽기. 열이 5까지만 있는 걸 헤매서 에러난 문제.

 */