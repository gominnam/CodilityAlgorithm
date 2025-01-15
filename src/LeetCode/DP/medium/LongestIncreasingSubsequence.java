package LeetCode.DP.medium;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = Arrays.stream(dp).max().orElse(0);
        return maxLength;
    }

    public int lengthOfLIS_2(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(tails, 0, size, num);
            if (i < 0) i = -(i + 1);
            tails[i] = num;
            if (i == size) size++;
        }
        return size;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        int[] nums3 = {4, 10, 4, 3, 8, 9};
        System.out.println(lis.lengthOfLIS(nums)); // 4
        System.out.println(lis.lengthOfLIS(nums2)); // 4
        System.out.println(lis.lengthOfLIS(nums3)); // 3

        System.out.println(lis.lengthOfLIS_2(nums)); // 4
        System.out.println(lis.lengthOfLIS_2(nums2)); // 4
        System.out.println(lis.lengthOfLIS_2(nums3)); // 3
    }
}
