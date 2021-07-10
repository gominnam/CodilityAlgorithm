package Inflearn.Array;

import java.util.Scanner;

public class Rank {
    public int[] Solve(int n, int[] score){
        int[] answer = new int[n]; // 동적으로 잡으면 기본으로 0으로 초기화

        for(int i=0; i<score.length; i++){
            int cnt = 1;
            for(int j=0; j<score.length; j++){
                if(score[i] < score[j]){
                    cnt++;
                }
            }
            answer[i] = cnt;
        }

        return answer;
    }

    public static void main(String[] args){
        Rank T = new Rank();

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int score[] = new int[num];
        for(int i=0; i<num; i++){
            score[i] = sc.nextInt();
        }

        for(int x : T.Solve(num, score)){
            System.out.print(x + " ");
        }

    }
}
/*  복잡하게 생각하지 말고 풀 것.

N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.

같은 점수가 입력될 경우 높은 등수로 동일 처리한다.

즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.

 */