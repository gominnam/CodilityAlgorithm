package BaekJoon.Etc;

import java.io.*;
import java.util.StringTokenizer;

public class Topology_2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");//a가 b보다 작다.
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

        }


        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
        ## 위상정렬 - 시간복잡도 O(N + M) //정점의 갯수 + 간선의 갯수 만큼 시간 소요

    TIP - 1. Stack/Queue 중 하나를 선택해 해결할 수 있다.(자료구조 선택하여 사용) // 아래는 Queue를 사용했을 때
          2. 진입차수가 0인 정점을 큐에 삽입
          3. 큐에서 원소를 꺼내 연결된 모든 간선을 제거
          4. 간선 제거 이후에 진입차수가 0이 된 정점을 큐에 삽입한다.
          5. 큐가 빌 때까지 2번 ~ 3번 과정을 반복한다. 모든 원소를 방문하기 전에 큐가 빈다면 사이클이 존재하는 것이고,
             모든 원소를 방문한다면 큐에서 꺼낸 순서가 위상정렬 결과이다.


 */
