package Inflearn.Array;

import java.util.Scanner;

public class Mentoring {
    public int Solve(int n1, int n2, int[][] arr){//n1: 학생수, n2: 테스트 수
        int answer = 0;
        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n1; j++){
                int cnt = 0;
                for(int k=0; k<n2; k++){
                    int pi=0, pj=0;
                    for(int s=0; s<n1; s++){
                        if(arr[k][s]==i) pi=s;
                        if(arr[k][s]==j) pj=s;
                    }
                    if(pi<pj) cnt++;
                }
                if(cnt==n2){
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Mentoring T = new Mentoring();

        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt(); //반 학생수
        int n2 = sc.nextInt(); // 테스트 수
        int arr[][] = new int[n2][n1];
        for(int i=0; i<n2; i++){
            for(int j=0; j<n1; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(T.Solve(n1, n2, arr));
    }
}

/*

    retire..
    4중 for문 문제 다시풀어보기(멘토링 문제)
    때로는 for문으로 푸는게 정답일 수 있다.
    (i, j)

 */