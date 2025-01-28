package LeetCode.Queue.medium;

import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num : nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(frequencyMap.entrySet());

        int[] result = new int[k];
        for(int i=0; i<k; i++){
            result[i] = pq.poll().getKey();
        }
        return result;
    }

    public int[] topKFrequent_2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length; i > 0 && res.size() < k; i--) {
            if (bucket[i] != null) res.addAll(bucket[i]);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent(nums, k)));
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent_2(nums, k)));
    }
}

/*

Thinking:
1)
- Map과 PriorityQueue를 활용하여 문제 해결
    - PriorityQueue 에서 내림차순 정렬에서 Lambda 표현식 사용

- Lambda 표현식
    - 람다 표현식은 익명 함수(anonymous function)를 작성하기 위한 식.
    - (a, b) -> b.getValue() - a.getValue()
        - a, b는 Map.Entry<Integer, Integer> 타입
        - b.getValue() - a.getValue() : 내림차순 정렬
        - a.getValue() - b.getValue() : 오름차순 정렬

2)
- topKFrequent_2 : 시간복잡도 O(N), 공간복잡도 O(N)
    - bucket 정렬을 활용하여 문제 해결
    - bucket[i] : i번째 빈도수를 가진 숫자들의 리스트

- Stream API
    - 스트림은 컬렉션 데이터를 다루는데 유용한 기능을 제공
    - 선언형 스타일로 데이터 처리가 가능하고, 병렬 처리를 쉽게 할 수 있다.
    - res.stream().mapToInt(i -> i).toArray()
        - List<Integer> -> IntStream -> int[]

-ref : https://leetcode.com/problems/top-k-frequent-elements/

 */