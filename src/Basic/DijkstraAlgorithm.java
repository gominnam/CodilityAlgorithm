package Basic;

import java.util.*;

public class DijkstraAlgorithm {
    public void dijkstra(int[][] graph, int start) {
        int n = graph.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            if (visited[u]) {
                continue;
            }
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !visited[v]) {
                    int alt = dist[u] + graph[u][v];
                    if (alt < dist[v]) {
                        dist[v] = alt;
                        queue.offer(v);
                    }
                }
            }
        }

        // 최단 거리 출력
        System.out.println("최단 거리:");
        for (int i = 0; i < n; i++) {
            System.out.println(start+1 + "에서 " + (i+1) + "까지의 거리: " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 7, 0, 5, 0, 0},
                {7, 0, 8, 9, 7, 0},
                {0, 8, 0, 0, 5, 0},
                {5, 9, 0, 0, 15, 6},
                {0, 7, 5, 15, 0, 8},
                {0, 0, 0, 6, 8, 0}
        };
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm();
        dijkstra.dijkstra(graph, 0);
    }
}
/*
다익스트라(Dijkstra) 알고리즘은 최단 경로를 찾는 알고리즘으로, 가중치 그래프에서 한 정점에서 다른 모든 정점까지의 최단 거리를 찾는 데 사용됩니다.

위의 자바로 구현한 다익스트라 알고리즘 예제 코드입니다. 이 코드는 우선순위 큐를 사용하여 구현되었습니다.

위의 코드에서 graph는 인접 행렬로 표현된 가중치 그래프를 나타냅니다. start는 시작 정점의 인덱스를 나타냅니다.

dijkstra 메서드는 우선순위 큐를 사용하여 다익스트라 알고리즘을 구현하고, 최단 거리를 출력합니다. main 메서드에서는 인접 행렬과 시작 정점을 입력하여 dijkstra 메서드를 호출합니다.

위의 예제 코드를 실행하면, 0에서 다른 모든 정점까지의 최단 거리를 출력합니다.

** 모든 노드들의 최소 연결은 프림 알고리즘
   다익스트라는 시작 정점에서 목적지 까지 가는 최소비용을 구하는 알고리즘이다.
   차이점을 인지해야한다.

ref - chatGPT


{0, 0, 41, 10, 24, 25},
                {0, 0, 22, 66, 0, 0},
                {41, 22, 0, 0, 24, 0},
                {10, 66, 0, 0, 0, 50},
                {24, 0, 24, 0, 0, 2},
                {25, 0, 0, 50, 2, 0}
 */
