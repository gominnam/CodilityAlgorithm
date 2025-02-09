package LeetCode.DP.medium;

public class HouseRobber {

    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        nums[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length; i++){
            nums[i] = Math.max(nums[i] + nums[i-2], nums[i-1]);
        }

        return nums[nums.length-1];
    }

    public int rob_2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int b1 = 0, b2 = 0, result = 0; // b1: dp[i-1], b2: dp[i-2]

        for (int i = 0; i < nums.length; i++) {
            result = Math.max(nums[i] + b2, b1);

            b2 = b1;
            b1 = result;
        }

        return result;
    }



    public static void main(String[] args) {
        HouseRobber o = new HouseRobber();
        int[] nums = {1, 2, 3, 1};
        int[] nums2 = {2, 7, 9, 3, 1};
        int[] nums3 = {2, 1, 1, 2};
        System.out.println(o.rob(nums)); // 4
        System.out.println(o.rob(nums2)); // 12
        System.out.println(o.rob(nums3)); // 4

//        System.out.println(o.rob_2(nums)); // 4
//        System.out.println(o.rob_2(nums2)); // 12
//        System.out.println(o.rob_2(nums3)); // 4
    }
}

/*

Thinking:
- dynamic programming 문제
- dp[i] = max(dp[i-2] + nums[i], dp[i-1])
- 처음 nums[0]과 nums[1] 중 큰 값을 dp[1]에 저장 하는 것이 중요

- rob_2는 b1: dp[i-1], b2: dp[i-2] 로 캐싱하여 푸는 방식

-ref: https://leetcode.com/problems/house-robber/

 */