package Programmers.Level3;

import java.util.LinkedList;
import java.util.Queue;

public class CrossingTheSteppingStone {//todo: repeat
    public int solution(int[] stones, int k) {
        int answer = Integer.MIN_VALUE;
        int left = 1;
        int right = 200000000;
        while(left <= right){
            int mid = (left+right)/2;
            int cnt = 0;
            for(int i=0; i<stones.length; i++){
                cnt = stones[i]-mid < 0 ? cnt+1 : 0;
                if(cnt == k) break;
            }
            if(cnt < k) {
                left = mid+1;
                answer = Math.max(answer, mid);
            }
            else right = mid-1;
        }

        return answer;
    }

    public static void main(String[] args){
        CrossingTheSteppingStone ctss = new CrossingTheSteppingStone();
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.print(ctss.solution(stones, k));
    }
}
/*
feed back:

정확도는 맞았지만 효율성 테스트에서는 실패 소스

    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        int ptr = 0;
        for(int i=k-1; i<stones.length; i++, ptr++){
            int max = 0;
            for(int j=ptr; j<=i; j++){
                max = Math.max(max, stones[j]);
            }
            answer = Math.min(answer, max);
        }
        return answer;
    }

해결방법:

Binary Search (이분탐색)



int left = 1, right = 1 << 30, max = 0;
        while(left <= right){
            int mid = (left / 2) + (right / 2), cnt = 0;
            for(int i : stones) {
                cnt = (i - mid) < 0 ? cnt + 1 : 0;
                if(cnt == k) break;
            }
            if(cnt < k) {
                left = mid + 1;
                max = Math.max(max, mid);
            }
            else right = mid - 1;
        }
        return max;

 */
