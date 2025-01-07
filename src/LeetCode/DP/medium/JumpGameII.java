package LeetCode.DP.medium;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameII {

    public int jump(int[] nums){
        if(nums.length == 1) return 0;
        int[] dp = new int[nums.length];
        for(int i=1; i<nums.length; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[nums.length - 1];
    }

    public int jump_greedy(int[] nums) {
        int n = nums.length;

        int jumps = 0;
        int l = 0;  //consider farthest
        int r = 0;  //consider end point

        for (int i = 0; i < n - 1; i++) {
            l = Math.max(l, i + nums[i]);

            if (i == r) { //here we reached to the end point
                r = l;   //here end point point becomes the farthest point
                jumps++;  //here jumps increrments,
            }
        }

        return jumps;
    }

    public int jump_timeLimitExceeded(int[] nums) {
        boolean[] cache = new boolean[nums.length];
        Queue<Integer> queue = new LinkedList<>();
        if(nums.length == 1) return 0;
        queue.add(0);
        int min = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int cur = queue.poll();
                if(cache[cur]) continue;
                for(int j=1; j<=nums[cur]; j++){
                    if(cur + j == nums.length-1) return min+1;
                    if(cur + j > nums.length-1) break;
                    queue.offer(cur+j);
                }
            }
            min++;
        }
        return min;
    }

    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jumpGameII.jump(nums)); // 2
        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println(jumpGameII.jump(nums2)); // 2
        int[] num3 = {1, 2};
        System.out.println(jumpGameII.jump(num3)); // 1
    }
}

/*

Thinking:
1) jump_timeLimitExceeded
- 처음에는 Queue를 사용하여 문제 해결하려고 코딩했지만 시간복잡도에서 실패
- 시간복잡도 O(n^2)
2) jump
- dp를 사용하여 최적화
- 시간복잡도 최악의 경우 O(n^2) 이지만 중복 계산을 피하고, 각 위치에서 최소 점프 횟수를 갱신합니다.
3) jump_greedy
- greedy algorithm을 사용하여 최적화
- 시간복잡도 O(n)
- l은 현재 위치에서 갈 수 있는 최대 위치
- r은 현재 위치에서 갈 수 있는 최대 위치 중 가장 먼 위치


-ref: https://leetcode.com/problems/jump-game-ii/

 */