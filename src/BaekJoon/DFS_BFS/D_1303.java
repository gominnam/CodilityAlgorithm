package BaekJoon.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D_1303 {
    static int W, B=0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] map;
    static boolean[][] visited;

    public static int dfs(int y, int x, char color, int depth){
        visited[y][x] = true;
        for(int i=0; i<4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny>=0 && nx>=0 && ny<map.length && nx<map[0].length){
                if(!visited[ny][nx] && map[ny][nx] == color){
                    depth = dfs(ny, nx, color, depth+1);
                }
            }
        }
        return depth;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new char[M][N];
        for(int i=0; i<M; i++){
            String str = br.readLine();
            for(int j=0; j<str.length(); j++){
                map[i][j] = str.charAt(j);
            }
        }
        visited = new boolean[M][N];
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    int depth = dfs(i, j, map[i][j], 1);
                    if(map[i][j] == 'W'){
                        W += depth*depth;
                    }
                    else{
                        B += depth*depth;
                    }
                }
            }
        }
        System.out.println(W + " " + B);
    }
}

/*

Computer에서 array 선언 시, row와 column을 바꿔서 선언하면 헷갈리지 않는다.
ex) int[][] arr = new int[M][N];
M: row(높이, y), N: column(너비, x)

TESTCASE:
5 5
WBWWW
WWWWW
BBBBB
BBBWW
WWWWW

6 5
WBWWW
WWWWW
BBBBB
BBBWW
WWWWW

==>
130 65


 */