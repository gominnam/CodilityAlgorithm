package BaekJoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BT_15650 {
    static int N, M;
    static int[] arr;
    static boolean[] visited;

    public static void dfs(int start, int depth){
        if(depth == M){
            for(int i=0; i<M; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i=start; i<=N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                dfs(i+1, depth+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited = new boolean[N+1];
        dfs(1, 0);
    }
}

/*

위의 문제는 중복되는 수열도 미출력

TESTCASE:
4 2

==>
1 2
1 3
1 4
2 3
2 4
3 4

 */