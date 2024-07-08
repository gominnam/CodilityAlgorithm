package BaekJoon.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int x;
    int y;
    int dir;
    int cnt;

    Node(int x, int y, int dir, int cnt){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cnt = cnt;
    }
}

public class B_2151 {
    static char[][] map;
    static int[][] visited; // visited[nr][nc][d] = true; 이 방법으로 방향 고려해서 보다 낳은 효율 향상 기대 가능
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // dir[0], [1] <-> dir[2], [3]  // +2 하고 3으로 남은 나머지 idx
    static int N;

    public static int bfs(int[][] doors) {
        Queue<Node> queue = new LinkedList<>();
        for(int i=0; i<4; i++){
            queue.add(new Node(doors[0][0], doors[0][1], i, 0));
        }
        visited[doors[0][0]][doors[0][1]] = 0;
        while(!queue.isEmpty()){
            Node current = queue.poll();
            int x = current.x;
            int y = current.y;
            int[] mirror = new int[2];
            if(current.dir < 2){
                mirror[0] = 2;
                mirror[1] = 3;
            }
            else {
                mirror[0] = 0;
                mirror[1] = 1;
            }
            while(true){
                x += dir[current.dir][0];
                y += dir[current.dir][1];
                if(x < 0 || y < 0 || x >= N || y >= N || map[x][y] == '*') break;
                if(map[x][y] == '!'){
                    queue.add(new Node(x, y, mirror[0], current.cnt+1));
                    queue.add(new Node(x, y, mirror[1], current.cnt+1));
                }
                if(x == doors[1][0] && y == doors[1][1]) return current.cnt;
            }
        }
        return -1;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new int[N][N];
        for(int i=0; i<N; i++){
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        int[][] doors = new int[2][2];
        int idx = 0;
        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = line.charAt(j);
                if(map[i][j] == '#'){
                    doors[idx][0] = i;
                    doors[idx][1] = j;
                    idx++;
                }
            }
        }
        bw.write(String.valueOf(bfs(doors)));
        bw.flush();
        bw.close();
        br.close();
    }
}

/*

thinking:
visited를 사용하지 않고 해결했지만 숫자가 클경우 시간초과 우려가 있음 visited[][][] 3차원으로 하여 dir에 따른 캐싱처리를 생각하기


TEST CASE:
1)
5
***#*
*.!.*
*!.!*
*.!.*
*#***

==> 2

 */