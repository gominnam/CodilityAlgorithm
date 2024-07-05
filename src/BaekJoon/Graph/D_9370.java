package BaekJoon.Graph;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int end;
    int weight;

    Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.weight, o.weight);
    }
}

public class D_9370 {
    static final int INF = 123_456_789;
    static int T;
    static int n, m, t, s, g, h;

    public static int[] dijkstra(List<List<Node>> graph, int start){
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        boolean[] visited = new boolean[n+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node current = pq.poll();
            int curNode = current.end;

            if(visited[curNode]){
                continue;
            }
            visited[curNode] = true;
            for(Node node : graph.get(curNode)){
                if(dist[node.end] > dist[curNode] + node.weight){
                    dist[node.end] = dist[curNode] + node.weight;
                    pq.add(new Node(node.end, dist[node.end]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);//교차로
            m = Integer.parseInt(input[1]);//도로
            t = Integer.parseInt(input[2]);//목적지 후보
            input = br.readLine().split(" ");
            s = Integer.parseInt(input[0]);//예술가들의 출발지
            g = Integer.parseInt(input[1]);//g와 h 교차로 사이에 있는 도로를 지나갔다
            h = Integer.parseInt(input[2]);
            //목적지까지 우회하지 않고 최단거리로 갈 것이라 확신
            List<List<Node>> graph = new ArrayList<>();
            for(int i=0; i<=n; i++){
                graph.add(new ArrayList<>());
            }

            for(int i=0; i<m; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                if((start == g && end == h) || (start == h && end == g)){
                    weight = (weight * 2) - 1;
                }
                else{
                    weight = weight * 2;
                }
                graph.get(start).add(new Node(end, weight));
                graph.get(end).add(new Node(start, weight));
            }
            int[] dist = dijkstra(graph, s);
            List<Integer> candidates = new ArrayList<>();
            for(int i=0; i<t; i++){
                int candidate = Integer.parseInt(br.readLine());
                if(dist[candidate] % 2 == 1 && dist[candidate] != INF){
                    candidates.add(candidate);
                }
            }
            Collections.sort(candidates);
            for(int i : candidates){
                bw.write(i + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

/*

thinking:

그래프 구성:

각 교차로와 도로를 인접 리스트로 표현합니다.
입력으로 주어진 g와 h 사이의 도로는 특별한 마킹을 하여 후각을 통해 인식할 수 있습니다.
다익스트라 알고리즘 활용:

출발점에서 모든 교차로까지의 최단 거리를 계산합니다.
g와 h 사이의 도로를 반드시 거치는 경우를 고려하여 최단 경로를 계산

++

위 케이스의 최단 경로에서 2에서 3으로 가는 경로가 포함되어 있는지 확인하기 위해 생각해볼 수 있는 방법은 두 가지다.

첫 번째,
(1 -> 2 최단거리) + (2 -> 3 최단거리) + (3 -> 5 최단거리) == (1 -> 5 최단거리) 또는
(1 -> 3 최단거리) + (3 -> 2 최단거리) + (2 -> 5 최단거리) == (1 -> 5 최단거리)

위 방법은 가장 간단하게 생각해볼 수 있는 방법이지만, 다익스트라 함수를 여러 번 호출해야하기 때문에 비효율적인 방법이다.

!! 두 번째,
간선의 가중치를 저장할 때 2를 곱한 값을 저장해 짝수로 만들고, 확인하고자 하는 간선의 가중치에는 -1를 해줘 홀수로 만든다.



TEST CASE:
1)
2
5 4 2
1 2 3
1 2 6
2 3 2
3 4 4
3 5 3
5
4
6 9 2
2 3 1
1 2 1
1 3 3
2 4 4
2 5 5
3 4 3
3 6 2
4 5 4
4 6 3
5 6 7
5
6

==>
4 5
6

2)
1
5 3 2
1 2 3
1 2 1
2 3 2
3 4 3
4
5

==> 4
 */
