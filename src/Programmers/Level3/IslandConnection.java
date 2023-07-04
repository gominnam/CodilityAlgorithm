package Programmers.Level3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class IslandConnection {
    public static final int INF = Integer.MAX_VALUE;

    public class Node implements Comparable<Node>{
        int vertex;
        int weight;
        public Node(int v, int w){
            this.vertex = v;
            this.weight = w;
        }
        @Override
        public int compareTo(Node n){
            return this.weight - n.weight;
        }
    }

    public int primAlgorithm(int n, int[][] graph){
        int[] parent = new int[n];
        int[] key = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(key, INF);
        Arrays.fill(visited, false);

        int startVertex = 0;
        key[startVertex] = 0;
        parent[startVertex] = -1;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startVertex, 0));

        while(!pq.isEmpty()){
            int u = pq.poll().vertex;
            visited[u] = true;

            for(int v = 0; v < n; v++){
                if(graph[u][v] != 0 && !visited[v] && graph[u][v] < key[v]){
                    parent[v] = u;
                    key[v] = graph[u][v];
                    pq.offer(new Node(v, key[v]));
                }
            }
        }
        int result = 0;
        for(int i=0; i<n; i++){
            result += key[i];
        }
        return result;
    }

    public int solution(int n, int[][] costs) {
        int[][] graph = new int[n][n];
        for(int i=0; i<costs.length; i++){
           graph[costs[i][0]][costs[i][1]] = costs[i][2];
           graph[costs[i][1]][costs[i][0]] = costs[i][2];
        }
        return primAlgorithm(n, graph);
    }

    public static void main(String[] args){
        IslandConnection ic = new IslandConnection();
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        System.out.println(ic.solution(n, costs));
    }
}
