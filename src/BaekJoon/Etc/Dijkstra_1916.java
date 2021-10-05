package BaekJoon.Etc;

import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
    int e, w;//end, weight

    public Edge(int e, int w){
        this.e = e;
        this.w = w;
    }
    @Override
    public int compareTo(Edge e){
        return this.w - e.w;//this가 앞이면 오름차순(음수)
    }
}

public class Dijkstra_1916 {
    static ArrayList<ArrayList<Edge>> arr;
    static int[] dis; //최단거리
    static boolean[] visited; //방문

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        arr = new ArrayList<>();
        dis = new int[N+1];
        visited = new boolean[N+1];

        for(int i=0; i<=N; i++){
            arr.add(new ArrayList<>());
        }

        Arrays.fill(dis, Integer.MAX_VALUE);
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr.get(s).add(new Edge(e, w));
        }
        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        bw.write(dijkstra(start, end) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dijkstra(int start, int end){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dis[start] = 0;

        while (!pq.isEmpty()) {
            Edge curEdge = pq.poll();
            int cur = curEdge.e;

            if (!visited[cur]) {
                visited[cur] = true;

                for (Edge edge : arr.get(cur)) {
                    if (!visited[edge.e] && dis[edge.e] > dis[cur] + edge.w) {
                        dis[edge.e] = dis[cur] + edge.w;
                        pq.add(new Edge(edge.e, dis[edge.e]));
                    }
                }
            }
        }
        return dis[end];
    }
}
/*
첫째 줄에 출발 도시에서 도착 도시까지 가는데 드는 최소 비용을 출력한다.

TEST CASE:
5
8
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
1 5

==> 4

 */