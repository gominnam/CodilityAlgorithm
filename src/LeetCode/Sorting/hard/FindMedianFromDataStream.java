package LeetCode.Sorting.hard;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    private boolean even;

    public FindMedianFromDataStream() {
        this.small = new PriorityQueue<>(Collections.reverseOrder());
        this.large = new PriorityQueue<>();
        this.even = true;
    }

    public double findMedian() {
        if (even)
            return (small.peek() + large.peek()) / 2.0;
        else
            return small.peek();
    }

    public void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }

    public static void main(String[] args) {
        FindMedianFromDataStream median = new FindMedianFromDataStream();
        median.addNum(1);
        median.addNum(2);
        System.out.println(median.findMedian()); // 1.5
        median.addNum(3);
        System.out.println(median.findMedian()); // 2
    }
}

/*

Thinking:
- 이중큐까지 구현했지만 세부사항 실수로 시간이 걸림.
- 사이트에서 간결한 코드로 수정.

-ref: https://leetcode.com/problems/find-median-from-data-stream/submissions/1469321804/

 */