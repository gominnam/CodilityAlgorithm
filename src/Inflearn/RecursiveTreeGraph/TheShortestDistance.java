package Inflearn.RecursiveTreeGraph;

import java.util.*;

public class TheShortestDistance {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] check;
    static int[] dis;
    static int n, m = 0;

    public void solution(int v){
        Queue<Integer> Q = new LinkedList<>();
        check[v] = true;
        dis[v] = 0;
        Q.offer(v);
        while(!Q.isEmpty()){
            int cur = Q.poll();
            for(int x : graph.get(cur)){
                if(!check[x]) {
                    check[x] = true;
                    Q.offer(x);
                    dis[x] = dis[cur]+1; // 다음위치 = 현재위치 + 1
                }
            }
        }
    }

    public static void main(String[] args){
        TheShortestDistance T = new TheShortestDistance();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        check = new boolean[n+1];
        dis = new int[n+1];
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        T.solution(1);
        for(int i=2; i<=n; i++){
            System.out.println(i + " : " + dis[i]);
        }
    }
}

/* 그래프 최단거리(BFS)

TEST CASE:
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5

==>
2 : 3
3 : 1
4 : 1
5 : 2
6 : 2

 */