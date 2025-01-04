package LeetCode.HashTable.medium;

import java.util.*;

public class DiagonalTraverseII {

    List<List<Integer>> result = new ArrayList<>();

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        for(int i=0; i<nums.size(); i++){
            calculator(nums.get(i), i);
        }
        return flattenResult();
    }

    public void calculator(List<Integer> list, int idx){
        for(int i=0; i<list.size(); i++){
            int curIdx = i+idx;
            if(result.size() <= curIdx){
                result.add(new ArrayList<>());
                result.get(curIdx).add(list.get(i));
            }
            else {
                result.get(curIdx).add(0, list.get(i));
            }
        }
    }

    private int[] flattenResult() {
        List<Integer> flatList = new ArrayList<>();
        for (List<Integer> sublist : result) {
            flatList.addAll(sublist);
        }
        int[] flatArray = new int[flatList.size()];
        for (int i = 0; i < flatList.size(); i++) {
            flatArray[i] = flatList.get(i);
        }
        return flatArray;
    }

    public int[] findDiagonalOrder_leetCode_Answer(List<List<Integer>> nums) {
        int count = 0;

        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> row = nums.get(i);

            for (int j = 0; j < row.size(); j++) {
                int idx = i + j;

                if (lists.size() < idx + 1) {
                    lists.add(new ArrayList<>());
                }
                lists.get(idx).add(row.get(j));

                count ++;
            }
        }

        int[] res = new int[count];
        int idx = 0;
        for (List<Integer> list : lists) {
            for (int i = list.size() - 1; i >= 0; i--) {
                res[idx++] = list.get(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DiagonalTraverseII d = new DiagonalTraverseII();
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(1, 2, 3));
        nums.add(Arrays.asList(4, 5, 6));
        nums.add(Arrays.asList(7, 8, 9));
        System.out.println(Arrays.toString(d.findDiagonalOrder_leetCode_Answer(nums))); // [1,4,2,7,5,3,8,6,9]
    }
}

/*

- Thinking
: 어떤 자료구조를 사용할지 고민(List, Map, Set, Queue, Stack ...)
: 순서가 있고 중복을 허용하는 자료구조인 List를 사용

-ref: https://leetcode.com/problems/diagonal-traverse-ii/

 */