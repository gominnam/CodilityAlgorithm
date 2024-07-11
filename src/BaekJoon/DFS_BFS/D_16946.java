package BaekJoon.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class D_16946 {
    static int N, M, areaIdCounter = 1, count = 0;
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] map, areaId;
    static boolean[][] visited;
    static HashMap<Integer, Integer> areaSize = new HashMap<>();

    public static int dfs(int x, int y, int id){
        if(x < 0 || y < 0 || x >= N || y >= M || visited[x][y] || map[x][y] == 1) return 0;
        visited[x][y] = true;
        areaId[x][y] = id;
        int size = 1;
        for (int[] direction : directions) {
            size += dfs(x + direction[0], y + direction[1], id);
        }
        return size;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        areaId = new int[N][M];

        for(int i=0; i<N; i++) {
            String input = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = input.charAt(j)-'0';
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 0 && !visited[i][j]) {
                    int size = dfs(i, j, areaIdCounter);
                    areaSize.put(areaIdCounter, size);
                    areaIdCounter++;
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 0) {
                    sb.append(0);
                } else {
                    int totalSize = 1;
                    HashMap<Integer, Boolean> connectedAreas = new HashMap<>();
                    for (int[] direction : directions) {
                        int nx = i + direction[0];
                        int ny = j + direction[1];
                        if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0 && !connectedAreas.containsKey(areaId[nx][ny])) {
                            totalSize += areaSize.get(areaId[nx][ny]);
                            connectedAreas.put(areaId[nx][ny], true);
                        }
                    }
                    sb.append(totalSize % 10);
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

/*

Thinking:

기본 DFS는 시간초과 발생.
Area를 구분하여 미리 구역별 넓이를 caching하고 이를 활용하여 시간초과 문제 해결

TEST CASE:
1)
3 3
101
010
101

==>
303
050
303

2)
3 3
111
111
111

==>
111
111
111

 */
