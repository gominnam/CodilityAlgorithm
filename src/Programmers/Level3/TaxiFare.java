package Programmers.Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class TaxiFare {
    public class Node implements Comparable<Node>{
        int d;
        int p;
        public Node(int d, int p){
            this.d = d;
            this.p = p;
        }
        @Override
        public int compareTo(Node n){
            return Integer.compare(p, n.p);
        }
    }

    public int[] dijkstra(ArrayList<Node>[] nodes, int start, int n){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        int[] dis = new int[n+1];

        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(visited[cur.d]){
                continue;
            }
            visited[cur.d] = true;

            for(Node to : nodes[cur.d]){
                int dist = dis[cur.d]+to.p;
                if(dist < dis[to.d]){
                    dis[to.d] = dist;
                    pq.add(new Node(to.d, dis[to.d]));
                }
            }
        }
        return dis;
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int min = Integer.MAX_VALUE;
        ArrayList<Node>[] nodes = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            nodes[i] = new ArrayList<>();
        }

        for(int i=0; i<fares.length; i++){
            nodes[fares[i][0]].add(new Node(fares[i][1], fares[i][2]));
            nodes[fares[i][1]].add(new Node(fares[i][0], fares[i][2]));
        }

        int[] A = dijkstra(nodes, a, n);
        int[] B = dijkstra(nodes, b, n);
        int[] S = dijkstra(nodes, s, n);

        for(int i=1; i<=n; i++){
            min = Math.min(min, (A[i]+B[i]+S[i]));
        }

        return min;
    }

    public static void main(String[] args){
        TaxiFare tf = new TaxiFare();
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        System.out.print(tf.solution(n, s, a, b, fares));
    }
}
/*
feedback:

algorithm:
dijkstra(다익스트라)를 사용해야하는 문제
그래프의 두 정점 사이의 최단 경로를 찾을 수 있는 알고리즘.
두 정점 사이의 최단 거리는 그래프의 모든 정점을 포함하지 않을 수 있기 때문에 최소 신장 트리와 다르다.


step:
- 가중 그래프로 시작
- 시작 정점을 시작하고 다른 모든 장치에 무한 경로 값을 할당한다.
- 각 정점으로 이동하여 경로 업데이트
- 인접한 정점의 경로 길이가 새 경로 길이보다 작으면 업데이트하지 않는다.
- 이미 방문한 정점의 경로 길이 업데이트 방지
- 각 반복 후 경로 길이가 가장 짧은 미방문 정점을 선택한다.
- 모든 정점을 방문할 때 까지 반복


tip:
- 가장 짧은 정점을 효율적으로 구하기 위해 최소우선순위큐(PriorityQueue)를 사용하면 좋다.
- 시간복잡도 O(ElogV) // E: 모서리의 수, V: 정점의 수
- 공간복잡성 O(V)


booster answer:
다른사람 소스

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] map = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(map[i], 100_000_000);
            map[i][i] = 0;
        }
        for (int[] fare : fares)
            map[fare[0]][fare[1]] = map[fare[1]][fare[0]] = fare[2];

        for (int k = 1; k <= n; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    if (map[i][j] > map[i][k] + map[k][j])
                        map[i][j] = map[i][k] + map[k][j];

        int answer = map[s][a] + map[s][b];

        for (int i = 1; i <= n; i++)
            answer = Math.min(answer, map[s][i] + map[i][a] + map[i][b]);


        return answer;
    }

 */
