package BaekJoon.Graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class F_11657 {
    static final int INF = Integer.MAX_VALUE;

    public static List<Integer> floyd(int[][] map, int N){
        List<Integer> result = new ArrayList<>();
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if (map[i][k] != INF && map[k][j] != INF && map[i][k] + map[k][j] < map[i][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        // 1번 노드와 연결된 노드 확인
        boolean[] connected = new boolean[N+1];
        for(int i=1; i<=N; i++){
            if(map[1][i] != INF || map[i][1] != INF){
                connected[i] = true;
            }
        }

        // 결과 리스트 생성
        for(int i=2; i<=N; i++) {
            if (connected[i] && map[i][i] < 0) { // 1번 노드와 연결되지 않았거나 음수 사이클이 있는 경우
                return new ArrayList<>(Arrays.asList(-1));
            } else if (map[1][i] == INF) { // 1번 노드에서 해당 노드로 가는 경로가 없는 경우
                result.add(-1);
            } else { // 1번 노드에서 해당 노드로 가는 최단 경로가 있는 경우
                result.add(map[1][i]);
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 도시수
        int M = Integer.parseInt(st.nextToken()); // 노선 수
        int[][] map = new int[N+1][N+1];
        for(int i=0; i<=N; i++){
            Arrays.fill(map[i], INF);
            map[i][i] = 0; // 자기 자신으로의 경로는 0으로 초기화
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if(map[A][B] > C){
                map[A][B] = C;
            }
        }

        for(Integer i : floyd(map, N)){
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

/*


thinking:
틀린 이유
1) 도시간의 버스노선이 여러개일수있는데 이부분에 대한 고려를 안함.
2) C는 음수, 0일 수 있음 (0의 조건을 제외함)

// 음수 사이클이 있는 경우
for(int i=1; i<=N; i++){
    if(map[i][i] < 0){
        return new ArrayList<>(Arrays.asList(-1));
    }
}

풀이가 더 수월했을 알고리즘
==> 벨만포드 알고리즘 (B_11657)

TEST CASE:
1)
3 4
1 2 4
1 3 3
2 3 -1
3 1 -2

==>
4
3

2)
3 4
1 2 4
1 3 3
2 3 -4
3 1 -2

==>
-1

 */
