package BaekJoon.Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class F_1956 {
    static final int INF = 123_456_789;
    static int V, E; // 노드 수, 간선 수
    static int[][] map;

    public static void floydWarshall(){
        for(int k=1; k<=V; k++){
            for(int i=1; i<=V; i++){
                for(int j=1; j<=V; j++){
                    if(map[i][j] > map[i][k] + map[k][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
    }

    public static int calculationCycle(){
        int answer = INF;
        for(int i=1; i<=V; i++){
            for(int j=1; j<=V; j++){
                if(i == j) continue;
                if(map[i][j] == INF || map[j][i] == INF) continue;
                int cycle = map[i][j] + map[j][i];
                answer = Math.min(answer, cycle);
            }
        }
        return answer == INF ? -1 : answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);
        map = new int[V+1][V+1];
        for(int i=0; i<V+1; i++){
            Arrays.fill(map[i], INF);
        }
        for(int i=0; i<E; i++){
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            map[start][end] = weight;
        }
        floydWarshall();
        bw.write(String.valueOf(calculationCycle()));
        bw.flush();
        bw.close();
        br.close();
    }
}
/*

TEST CASE:
1)
3 4
1 2 1
3 2 1
1 3 5
2 3 2

==> 3

2)
4 5
1 2 1
2 3 1
3 4 1
4 2 1
2 1 100

==> 3

 */