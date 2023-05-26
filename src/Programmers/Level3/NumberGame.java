package Programmers.Level3;

import java.util.Arrays;

public class NumberGame {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int aPtr = 0;
        for(int i=0; i<B.length; i++){
            if(B[i] > A[aPtr]) {
                answer++;
                aPtr++;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        NumberGame ng = new NumberGame();
        int[] A = {5,1,3,7};
        int[] B = {2,2,6,8};
        System.out.println(ng.solution(A, B));
    }
}
