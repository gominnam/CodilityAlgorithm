package Basic;

import java.util.*;

public class PrimAlgorithm {
    private static final int INF = Integer.MAX_VALUE; // 무한대 값

    public void primMST(int[][] graph) {
        int V = graph.length; // 정점의 개수
        int[] parent = new int[V]; // 최소 신장 트리에서 각 정점의 부모 정점을 저장할 배열
        int[] key = new int[V]; // 최소 신장 트리에서 해당 정점과 연결된 간선의 가중치를 저장할 배열
        boolean[] visited = new boolean[V]; // 방문 여부를 저장할 배열

        // key 배열을 무한대로 초기화하고, 모든 정점을 방문하지 않은 상태로 설정
        Arrays.fill(key, INF);
        Arrays.fill(visited, false);

        // 시작 정점을 선택하고 key 값을 0으로 설정
        int startVertex = 0;
        key[startVertex] = 0;
        parent[startVertex] = -1;

        // 우선순위 큐를 사용하여 최소 비용의 간선을 선택
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startVertex, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;
            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !visited[v] && graph[u][v] < key[v]) {
                    // u와 v 사이의 간선의 가중치가 현재 key[v] 값보다 작을 경우, key[v] 값을 업데이트하고 우선순위 큐에 추가
                    parent[v] = u;
                    key[v] = graph[u][v];
                    pq.offer(new Node(v, key[v]));
                }
            }
        }

        // 최소 신장 트리 출력
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    // 우선순위 큐에 넣을 노드 클래스
    class Node implements Comparable<Node> {
        int vertex; // 정점
        int weight; // 가중치

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }

    public static void main(String[] args) {
        PrimAlgorithm pa = new PrimAlgorithm();
        int[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };
        pa.primMST(graph);
    }
}
/*
프림 알고리즘(Prim's Algorithm)은 그래프의 모든 정점을 포함하는 최소 비용의 신장 트리(Minimum Spanning Tree)를 찾기 위한 알고리즘이다.
최소 신장 트리는 모든 정점을 연결하면서 간선의 가중치 합이 최소가 되는 트리이다.

프림 알고리즘은 그리디(Greedy) 알고리즘의 한 종류로, 시작 정점에서 출발하여 현재 선택된 정점과 열결되는 간선 중 가장 작은 가중치를
가지는 간선을 선택하는 방식으로 작동한다. 이후에는 선택된 간선의 도착 정점을 새로운 정점 집합에 추가하고, 해당 정점에서부터 다시 가장 작은
가중치를 가지는 간선을 선택하는 과정을 반복합니다. 이를 모든 정점이 선택될 때까지 반복하면 최소 신장 트리를 구할 수 있다.

[TIP]
1. 우선순위 큐를 사용하여 간선 가중치를 관리
2. 인접리스트나 인접행렬을 활용하여 그래프를 표현한다.

parent 배열은 index의 노드가 연결된 노드 정보를 갖는다.
key 배열은 index의 노드와 연결된 가중치 정보를 갖는다.

ref - chatGPT


 */
