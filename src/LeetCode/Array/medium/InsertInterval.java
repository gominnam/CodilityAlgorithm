package LeetCode.Array.medium;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Add all intervals before the new interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge all overlapping intervals with the new interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(new int[]{newInterval[0], newInterval[1]});

        // Add all intervals after the new interval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public int[][] insert_2(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        boolean added = false;
        for (int[] itv : intervals) {
            if (added || itv[1] < newInterval[0]) { // 병합 전, 병합 후
                result.add(itv);
            } else if (itv[0] > newInterval[1]) { // 병합
                result.add(newInterval);
                result.add(itv);
                added = true;
            } else { // 병합
                newInterval[0] = Math.min(newInterval[0], itv[0]);
                newInterval[1] = Math.max(newInterval[1], itv[1]);
            }
        }
        if (!added) {
            result.add(newInterval);
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        InsertInterval o = new InsertInterval();
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] res = o.insert(intervals, newInterval); // [1, 5], [6, 9]
        for (int[] re : res) {
            System.out.println(re[0] + " " + re[1]);
        }
        System.out.println();
        intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}, {17, 20}};
        newInterval = new int[]{4, 8};
        res = o.insert_2(intervals, newInterval); // [1, 2], [3, 10], [12, 16], [17, 20]
        for (int[] re : res) {
            System.out.println(re[0] + " " + re[1]);
        }
    }
}

/*

Thinking:
- 하나의 for문 안에서 병합을 하려고 해서 문제 해결을 못했음.
- 다른 풀이를 참고하여 interval을 삽입하는 3가지 경우를 나누어서 풀이(병합 전, 병합, 병합 후)
- 병합 하는 부분에서 newInterval의 값을 min, max 값으로 수정하는게 핵심.

- insert_2 메소드는 insert 메소드를 조금 더 간결하게 표현한 것.

-ref: https://leetcode.com/problems/insert-interval/

 */