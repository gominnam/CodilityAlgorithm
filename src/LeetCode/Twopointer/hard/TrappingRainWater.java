package LeetCode.Twopointer.hard;

public class TrappingRainWater {
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int waterTrapped = 0;

        while (left < right) {
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                } else {
                    waterTrapped += leftMax - height[left];
                }
                left++;
            } else {
                if(height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    waterTrapped += rightMax - height[right];
                }
                right--;
            }
        }

        return waterTrapped;
    }

    public static void main(String[] args) {
        TrappingRainWater o = new TrappingRainWater();
        System.out.println(o.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));//6
        System.out.println(o.trap(new int[]{4,2,0,3,2,5}));//9
    }
}

/*

Thinking:
- two pointer: left, right 사용하여 칸 채우기
- leftMax, rightMax 사용하여 현재 위치에서 물이 찰 수 있는 최대 높이 저장
- waterTrapped 현재 위치에서 물이 찰 수 있는 양 저장

-ref: https://leetcode.com/problems/trapping-rain-water/

 */