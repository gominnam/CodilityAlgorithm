package BaekJoon.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class PQ_1655 {
    private PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder()); // max heap
    private PriorityQueue<Integer> high = new PriorityQueue<>(); // min heap

    public void addNum(int num) {
        low.offer(num);
        high.offer(low.poll());
        if (low.size() < high.size()) {
            low.offer(high.poll());
        }
    }

    public int findMedian() {
        if (low.size() >= high.size()) {
            return low.peek();
        } else {
            return high.peek();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PQ_1655 medianFinder = new PQ_1655();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            medianFinder.addNum(num);
            sb.append(medianFinder.findMedian()).append("\n");
        }
        System.out.println(sb);
    }
}

/*
TEST CASE:
7
1
5
2
10
-99
7
5

=>
1
1
2
2
2
2
5


Collections.sort(list, Collections.reverseOrder()); // 내림차순

 */