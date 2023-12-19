package BaekJoon.Greedy;

import java.io.*;
import java.util.*;

public class G_1715 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> cards = new ArrayList<>();
        for(int i=0; i<N; i++){
            int dummyCnt = Integer.parseInt(br.readLine());
            cards.add(dummyCnt);
        }
        Collections.sort(cards);
        PriorityQueue<Integer> pq = new PriorityQueue<>(cards);
        long answer = 0;
        if(pq.size() == 1){
            bw.write(String.valueOf(answer));
            bw.flush();
            return;
        }
        while(!pq.isEmpty()){
            int a = pq.poll();
            int b = pq.poll();
            answer += a + b;
            if(pq.isEmpty()) break;
            pq.add(a + b);
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}

/*

PriorityQueue 우선순위큐 사용하여 가장 작은 값을 Queue 상단에 두어 2개의 값을 계속해서 더해가는 문제.

Stack 자료구조 2개를 생성하여 풀이 할 수 도 있을 거 같음.

 */