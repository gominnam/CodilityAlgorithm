package LeetCode.BinaryTree.easy;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            if(nums[i] == target) return i;
            else if(nums[i] > target) return i;
        }
        return nums.length;
    }

    public int searchInsertBinarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return left;
    }

    public static void main(String[] args){
        SearchInsertPosition sip = new SearchInsertPosition();
        int[] nums = {1,3,5,6};
        System.out.println(sip.searchInsert(nums, 5));
    }
}

/*

Thinking:
1) searchInsert는 시간복잡도 O(n)으로 풀 수 있음.

2) 더 개선된 방법으로 이진 탐색[ O(log n) ]을 사용할 수 있음.
    - 정렬된 배열이기 때문에 이진 탐색 가능.
    - searchInsertBinarySearch 참고

 */