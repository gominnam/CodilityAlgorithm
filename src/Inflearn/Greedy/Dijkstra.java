package Inflearn.Greedy;

import java.util.*;

public class Dijkstra {
    static int n, m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;//간선 거리

    public static class Edge implements Comparable<Edge>{
        public int vex;//정점(vertex)
        public int cost;//비용
        Edge(int vex, int cost){
            this.vex = vex;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge e){
            return this.cost - e.cost;//오름차순(작은 값부터)
        }
    }

    public void solution(int v){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v, 0));
        dis[v] = 0;
        while(!pq.isEmpty()){
            Edge tmp = pq.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if(nowCost>dis[now]) continue;
            for(Edge e : graph.get(now)){
                if(dis[e.vex] > nowCost + e.cost){//경로를 거쳐가는 경우 cost가 더 저렴할 경우
                    dis[e.vex] = nowCost + e.cost;//update
                    pq.offer(new Edge(e.vex, nowCost + e.cost));
                }
            }
        }
    }

    public static void main(String[] args){
        Dijkstra T = new Dijkstra();
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Edge>());
        }
        dis=new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);//dis 값을 MAX로 초기화
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b, c));
        }
        T.solution(1);
        for(int i=2; i<=n; i++){
            if(dis[i] != Integer.MAX_VALUE) System.out.println(i+" : "+dis[i]);
            else System.out.println(i+" : IMPOSSIBLE");
        }
    }
}

/*
N * O(logN)
feedback
    1. Edge class를 만든다.(Comparable 오버라이드!!)
    2. distance 배열 최대값을 갖은 채 초기화
    3. 2차원 ArrayList를 만든다.(간선에서 간선 이동 정보)
    4. PriorityQueue를 사용하여 값을 update.(logN으로 시간복잡도 줄일 수 있다.)
    !!주의!! 다익스트라 음수가 나오면 안된다.

설명
가중치 방향그래프에서 1번 정점에서 모든 정점으로의 최소 거리비용을 출력하는 프로그램을 작성하시오.(경로가 없으면 IMPOSSIBLE을 출력한다.)

입력설명
첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연결정보와 거리비용이 주어진다.

출력설명
1번 정점에서 각 정점으로 가는 최소비용을 2번 정점부터 차례대로 출력하세요.

TEST CASE:
6 9
1 2 12
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5

==>
2 : 11
3 : 4
4 : 9
5 : 14
6 : IMPOSSIBLE

 */
