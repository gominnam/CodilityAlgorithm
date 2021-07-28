package Inflearn.BFSAndDFS;

import java.util.*;

public class NumberOfCombinations {
    int[][] dy = new int[35][35]; // 메모제이션!!

    public int solution(int n, int r){
        if(dy[n][r] > 0) return dy[n][r];
        if(n==r || r==0) return 1;
        else return dy[n][r] = (solution(n-1, r-1) + solution(n-1, r));
    }

    public static void main(String[] args){
        NumberOfCombinations T = new NumberOfCombinations();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(T.solution(n, r));
    }
}
