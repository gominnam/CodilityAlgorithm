package LeetCode.Queue.hard;

import java.util.*;

public class RearrangeStringkDistanceApart {

    public String rearrangeString(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        Queue<Map.Entry<Character, Integer>> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> e = pq.poll();
            e.setValue(e.getValue() - 1);
            q.add(e);
            sb.append(e.getKey());

            if (q.size() < k) {
                continue;
            }

            Map.Entry<Character, Integer> qe = q.poll();
            if (qe.getValue() > 0) {
                pq.add(qe);
            }
        }

        return sb.length() == s.length() ? sb.toString() : "";
    }

        public static void main(String[] args) {
        RearrangeStringkDistanceApart r = new RearrangeStringkDistanceApart();
        System.out.println(r.rearrangeString("aabbcc", 3));
        System.out.println(r.rearrangeString("programming", 3));
    }
}

/*

Thinking:
- K 만큼 어떻게 떨어트려야하는지가 핵심.
- K 만큼 떨어트리기 위해 K 만큼의 크기를 가진 Queue를 사용.

- Map.Entry
    : Map의 Key, Value를 가지고 있는 객체
    :

- Map.entrySet()
    : Map.Entry 객체를 Set에 담아서 반환
    : Map.Entry 객체로 구성하여 Map의 모든 항목을 반복(iterate)할 수 있다.

-ref: https://leetcode.com/problems/rearrange-string-k-distance-apart/

 */