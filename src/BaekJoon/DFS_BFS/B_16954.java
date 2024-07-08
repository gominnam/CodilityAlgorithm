package BaekJoon.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class B_16954 {
    static int N = 8;
    static char[][] map = new char[N][N];
    static int[][] dir = {{0, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean[][] visited = new boolean[N][N];
            while(size-- > 0){
                int[] cur = queue.poll();
                int curX = cur[0];
                int curY = cur[1];

                if(map[curX][curY] == '#'){
                    continue;
                }

                if(curX == 0 && curY == 7){
                    return 1;
                }

                for(int i=0; i<9; i++){
                    int nx = curX + dir[i][0];
                    int ny = curY + dir[i][1];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == '#' || visited[nx][ny]){
                        continue;
                    }

                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
            dropBrick();
        }
        return 0;
    }

    public static void dropBrick(){
        for(int i=N-1; i>=0; i--){
            for(int j=0; j<N; j++){
                if(i == N-1){
                    map[i][j] = '.';
                }
                else if(map[i][j] == '#'){
                    map[i+1][j] = '#';
                    map[i][j] = '.';
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = line.charAt(j);
            }
        }
        bw.write(String.valueOf(bfs(7, 0)));
        bw.flush();
        bw.close();
        br.close();
    }
}

/*

TEST CASE:
1)
........
........
........
........
........
.#######
#.......
........

==> 1

2)
........
........
........
........
#.......
.#######
#.......
........

==> 0

 */
