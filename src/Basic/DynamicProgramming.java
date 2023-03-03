package Basic;

import java.util.Arrays;

public class DynamicProgramming {
    static int[][] cache = new int[30][30];
    public static void main(String[] args){
        bino2(10, 4);
        System.out.println(cache[10][4]);
    }
    public static int bino2(int n, int r){
        //기저사례
        if(r==0 || n==r) return 1;
        if(cache[n][r] != 0){
            return cache[n][r];
        }
        //직접 계산한 뒤 배열에 저장
        return cache[n][r] = bino2(n-1, r-1) + bino2(n-1, r);
    }
}
/*
1. 메모제이션 활용(cache) // 중복연산
2. nCr 조합 ==> nCr = n-1Cr-1 + n-1Cr

 */
