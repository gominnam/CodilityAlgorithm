package BaekJoon.Graph;

import java.io.*;
import java.util.StringTokenizer;

public class F_11404 {
    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static int[][] map;

    public static void floyd(){
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(map[i][k] != INF && map[k][j] != INF){
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        for(int i=0; i<=N; i++){
            for(int j=0; j<=N; j++){
                map[i][j] = INF;
                if(i == j) {
                    map[i][j] = 0;
                }
            }
        }
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map[s][e] = Math.min(map[s][e], w);
        }
        floyd();
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                bw.write(map[i][j] == INF ? "0 " : map[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

/*

TEST CASE:

1)
5
14
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
3 5 10
3 1 8
1 4 2
5 1 7
3 4 2
5 2 4

==>
0 2 3 1 4
12 0 15 2 5
8 5 0 1 1
10 7 13 0 3
7 4 10 6 0

 */