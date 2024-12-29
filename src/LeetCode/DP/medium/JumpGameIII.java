package LeetCode.DP.medium;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII {

    public boolean canReach(int[] arr, int start) {
        if(arr[start] == 0) return true;
        boolean[] cache = new boolean[arr.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        cache[start] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            int[] next = new int[]{ cur-arr[cur], cur+arr[cur]};
            for(int i : next){
                if(i >= arr.length || i < 0 || cache[i]) continue;
                if(arr[i] == 0) return true;
                cache[i] = true;
                queue.add(i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        JumpGameIII jumpGameIII = new JumpGameIII();
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 5;
//        int[] arr = {3,0,2,1,2};
//        int start = 2;
        System.out.println(jumpGameIII.canReach(arr, start)); // true
    }
}

/*

Thinking:
- Queue 자료구조와 시간단축을 위해 cache boolean[] 을 활용.

-ref: https://leetcode.com/problems/jump-game-iii/submissions/

 */