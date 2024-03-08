package BaekJoon.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DB_1260 {
    public void DFS(int[][] graph, int start, boolean[] visited){
        visited[start] = true;
        System.out.print(start + " ");
        for(int i=1; i<graph.length; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                DFS(graph, i, visited);
            }
        }
    }

    public void BFS(int[][] graph, int start, boolean[] visited){
        int[] queue = new int[graph.length];
        int front = 0;
        int rear = 0;
        queue[rear++] = start;
        visited[start] = true;
        while(front < rear){
            int current = queue[front++];
            System.out.print(current + " ");
            for(int i=1; i<graph.length; i++){
                if(graph[current][i] == 1 && !visited[i]){
                    queue[rear++] = i;
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        DB_1260 db_1260 = new DB_1260();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N+1][N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        db_1260.DFS(graph, start, new boolean[N+1]);
        System.out.println();
        db_1260.BFS(graph, start, new boolean[N+1]);
    }
}

/*

- DFS: 깊이 우선 탐색

start 지점부터 visited = true
graph 크기만큼 for문
둘 사이에 간선이 있는지, visited 배열을 통해 방문한 노드인지 확인 후 방문 안하면 재귀 호출


- BFS: 너비 우선 탐색

TEST CASE:
4 5 1
1 2
1 3
1 4
2 4
3 4

==>
1 2 4 3
1 2 3 4

 */