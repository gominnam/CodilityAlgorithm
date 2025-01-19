package LeetCode.Queue.hard;

import java.util.TreeSet;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        TreeSet<Integer> tree = new TreeSet<>();
        for(int n : nums){
            if(n > 0 ) tree.add(n);
        }
        int answer = 1;
        while(!tree.isEmpty()){
            int num = tree.pollFirst();
            if(answer < num) return answer;
            answer++;
        }
        return answer;
    }

    public int firstMissingPositive_2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] >= 1 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int t = nums[i];
                nums[i] = nums[t - 1];
                nums[t - 1] = t;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }


    public static void main(String[] args) {
        FirstMissingPositive fmp = new FirstMissingPositive();
        int[] nums = {3,4,-1,1};
        System.out.println(fmp.firstMissingPositive_2(nums)); // 3
    }
}

/*

Thinking:
- 자료구조 중복허용 안하고 정렬되는 자료구조를 이용.
- firstMissingPositive_2 방법이 메모리, 속도 개선화된 풀이 방법
    > 시간복잡도 O(n), 공간복잡도 O(1)
    > 핵심 아이디어는 배열 자체를 일종의 해시 테이블처럼 활용하여 인덱스와 값을 매핑

-ref: https://leetcode.com/problems/first-missing-positive/

 */