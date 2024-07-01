package BaekJoon.Etc;

import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int end;
    int weight;

    public Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    public int compareTo(Node n){
        return this.weight - n.weight;
    }
}

public class Dijkstra_1238 {
    static int N, M, X;
    static ArrayList<ArrayList<Node>> arr = new ArrayList<>();
    static ArrayList<ArrayList<Node>> reverse_arr = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        for(int i=0; i<=N; i++){
            arr.add(new ArrayList<>());
            reverse_arr.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr.get(start).add(new Node(end, weight));
            reverse_arr.get(end).add(new Node(start, weight));
        }

        int[] dis1 = dijkstra(arr);
        int[] dis2 = dijkstra(reverse_arr);

        int max = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++){
            max = Math.max(max, dis1[i]+dis2[i]);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int[] dijkstra(ArrayList<ArrayList<Node>> a){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(X, 0));

        boolean[] visited = new boolean[N+1];
        int[] dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[X] = 0;

        while(!pq.isEmpty()){
            Node n = pq.poll();
            int cur = n.end;

            if(!visited[cur]){
                visited[cur] = true;

                for(Node node : a.get(cur)){
                    if(!visited[node.end] && dis[node.end] > dis[cur] + node.weight){
                        dis[node.end] = dis[cur] + node.weight;
                        pq.add(new Node(node.end, dis[node.end]));
                    }
                }
            }
        }
        return dis;
    }
}
/*

TEST CASE:
4 8 2
1 2 4
1 3 2
1 4 7
2 1 1
2 3 5
3 1 2
3 4 4
4 2 3

==>10

## 다익스트라

왕복 문제는 정점을 reverse 하여 구하면 최단거리 구할 수 있다.(단방향)
역방향으로 입력을 받으면 각 정점들(A)에서 X로 가는 최단거리를 X->A 최단거리

 */