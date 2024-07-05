package BaekJoon.Graph;

import java.io.*;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}

public class B_11657 {
    
    public static final int INF = Integer.MAX_VALUE;

    public static Edge[] edges;
    public static long[] dist;
    public static int N;
    public static int M;

    // 벨만-포드 알고리즘은 최대 N-1번의 반복을 통해 최단 경로를 갱신합니다.
    // 그 후, 추가로 한 번 더 모든 간선을 탐색하여, 만약 이때도 거리가 갱신된다면 음의 사이클이 존재한다고 판단합니다.
    // 따라서, 음의 사이클 존재 여부를 판단하는 부분은 N번째 반복에서 이루어져야 합니다.
    public static boolean bellmanford(int start){
        dist[start] = 0;
        boolean isCycle = false;

        for(int i=0; i<N; i++){ // 모든 노드에 대해 최대 N-1번 반복합니다. 이는 벨만-포드 알고리즘의 핵심으로, 모든 노드를 탐색하면서 최단 거리를 반복적으로 갱신합니다.
            isCycle = false;

            for(int j=0; j<M; j++){ // 모든 간선
                Edge cur = edges[j];

                if(dist[cur.start] == INF){
                    continue;
                }

                if (dist[cur.end] > dist[cur.start] + cur.weight) {
                    dist[cur.end] = dist[cur.start] + cur.weight;
                    isCycle = true;
                }
            }

            if(!isCycle){
                break;
            }
        }

        return isCycle;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 도시수
        M = Integer.parseInt(st.nextToken()); // 노선 수
        edges = new Edge[M];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(S, E, W);
        }

        dist = new long[N + 1];
        for(int i=1; i<=N; i++){
            dist[i] = INF;
        }

        if (bellmanford(1)){
            bw.write(String.valueOf(-1));
        } else {
            for (int i = 2; i <= N; i++){ // BufferedWriter는 문자열을 인자로 받음.
                bw.write(String.valueOf(dist[i] == INF ? -1 : dist[i]));
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}

/*

TEST CASE:
1)
3 4
1 2 4
1 3 3
2 3 -1
3 1 -2

==>
4
3

2)
3 4
1 2 4
1 3 3
2 3 -4
3 1 -2

==>
-1

 */
