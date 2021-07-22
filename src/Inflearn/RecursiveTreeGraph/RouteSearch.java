package Inflearn.RecursiveTreeGraph;

import java.util.*;

public class RouteSearch {
    static int[][] graph;
    static boolean[] check;
    static int n, m, answer = 0;

    public void solution(int v){
        if(v==n) answer++;
        else{
            for(int i=1; i<=n; i++){
                if(graph[v][i] == 1 && !check[i]){
                    check[i] = true;
                    solution(i);
                    check[i] = false; // !!다시 풀어줘야 한다
                }
            }
        }
    }

    public static void main(String[] args){
        RouteSearch T = new RouteSearch();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n+1][n+1];
        check = new boolean[n+1];
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
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