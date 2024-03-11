package BaekJoon.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q_2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1); // 내림차순으로 사용하기
        for(int i=0; i<N; i++){
            String[] str = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                pq.add(Integer.parseInt(str[j]));
                if(pq.size() > N){
                    pq.poll();
                }
            }
        }
        System.out.println(pq.poll());
    }
}

/*

# 우선순위 큐(Priority Queue)

1. 우선순위 큐는 데이터들이 우선순위를 가지고 있고, 우선순위가 높은 데이터가 먼저 나온다.
2. 그러므로 N번째보다 많은 크기의 값들은 poll()로 버린다.
3. N번째 수를 출력

//내림차순으로 PriorityQueue 사용하기
//PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

TESTCASE:
5
12 7 9 15 5
13 8 11 19 6
21 10 26 31 16
48 14 28 35 25
52 20 32 41 49

==>
35

 */
