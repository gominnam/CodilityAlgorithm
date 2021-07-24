package Inflearn.RecursiveTreeGraph;

import java.util.*;

public class RouteSearchAdjacencyList {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] check;
    static int n, m, answer = 0;

    public void solution(int v){
        if(v==n) answer++;
        else{
            for(int nextV : graph.get(v)){
                if(!check[nextV]){
                    check[nextV] = true;
                    solution(nextV);
                    check[nextV] = false;
                }
            }
        }
    }

    public static void main(String[] args){
        RouteSearchAdjacencyList T = new RouteSearchAdjacencyList();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        check = new boolean[n+1];
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        check[1] = true;
        T.solution(1);
        System.out.println(answer);
    }
}

/*

TEST CASE:
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5

==> 6

 */