package LeetCode.HashTable.medium;

import java.util.*;

public class LeastNumberOfUniqueIntegersAfterKRemovals {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for(int i : arr){
            tm.put(i, tm.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        pq.addAll(tm.entrySet());
        while(!pq.isEmpty() && k-- > 0){
            Map.Entry<Integer, Integer> entry = pq.poll();
            if(entry.getValue() == 1) continue;
            entry.setValue(entry.getValue() - 1);
            pq.add(entry);
        }

        return pq.size();
    }

    public int findLeastNumOfUniqueInts_gpt(int[] arr, int k) {
        // 요소의 빈도를 저장할 HashMap 생성
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // 빈도를 리스트에 추가하고 정렬
        List<Integer> frequencies = new ArrayList<>(frequencyMap.values());
        Collections.sort(frequencies);

        // k개의 요소 제거
        int uniqueCount = frequencies.size();
        for (int freq : frequencies) {
            if (k >= freq) {
                k -= freq;
                uniqueCount--;
            } else {
                break;
            }
        }

        return uniqueCount;
    }

    public static void main(String[] args) {
        LeastNumberOfUniqueIntegersAfterKRemovals l = new LeastNumberOfUniqueIntegersAfterKRemovals();
        int[] arr = {4, 3, 1, 1, 3, 3, 2};
        int k = 3;
        System.out.println(l.findLeastNumOfUniqueInts_gpt(arr, k)); // 2
    }
}

/*

-Thinking
:TreeMap은 기본적으로 키를 오름차순으로 정렬
    내림차순으로 정렬하려면 Comparator를 사용
      ex) TreeMap<Integer, String> descendingMap = new TreeMap<>(Comparator.reverseOrder());
    가장 앞의 데이터 가져오기
      ex) Map.Entry<Integer, String> firstEntry = treeMap.firstEntry();

:_gpt 소스
    처음에 Map으로 key, value에 데이터를 쌓고, 그이후로 key 값은 의미가 없는 data가 된다.
    해당 value만 갖고, K만큼 오름차순 정렬된 데이터를 차감하여 count를 return 하는 방법 으로 효율성 개선.


-ref: https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/

 */
