package BaekJoon.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class B_6097 {
    static char[][] map;
    static int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    static int answer = Integer.MAX_VALUE;
    static int H, W;

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int dir;
        int mirrorCnt;

        Node(int x, int y, int dir, int mirrorCnt){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.mirrorCnt = mirrorCnt;
        }

        @Override
        public int compareTo(Node n){
            return Integer.compare(this.mirrorCnt, n.mirrorCnt);
        }
    }

    public static void bfs(Node start, Node end){
        int[][][] visited = new int[H][W][4];
        for (int[][] row : visited) {
            for (int[] col : row) {
                Arrays.fill(col, Integer.MAX_VALUE);
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0; i<4; i++){
            pq.add(new Node(start.x, start.y, i, 0));
            visited[start.x][start.y][i] = 0;
        }

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(node.x == end.x && node.y == end.y){
                answer = Math.min(answer, node.mirrorCnt);
                return;
            }

            for(int i=0; i<4; i++){
                int nx = dir[i][0] + node.x;
                int ny = dir[i][1] + node.y;
                int newMirrorCnt = node.mirrorCnt;

                if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length || map[nx][ny] == '*'){
                    continue;
                }

                if(node.dir != i){
                    newMirrorCnt++;
                }

                if(visited[nx][ny][i] > newMirrorCnt){
                    visited[nx][ny][i] = newMirrorCnt;
                    pq.add(new Node(nx, ny, i, newMirrorCnt));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        W = Integer.parseInt(input[0]);
        H = Integer.parseInt(input[1]);
        map = new char[H][W];
        Node[] nodes = new Node[2];
        int index = 0;
        for(int i=0; i<H; i++){
            char[] m = br.readLine().toCharArray();
            for(int j=0; j<W; j++){
                map[i][j] = m[j];
                if(map[i][j] == 'C'){
                    nodes[index++] = new Node(i, j, -1, 0);
                }
            }
        }
        bfs(nodes[0], nodes[1]);
        System.out.print(answer);
    }
}

/*

Thinking:
visited를 고려안한 bfs, dfs 문제풀이는 메모리초과 발생
visite[][][4] << 방향마다 count를 고려하여 이전 비용보다 작을경우에만 add 하는 로직 구현

TEST CASE:

1)
7 8
.......
......C
......*
*****.*
....*..
....*..
.C..*..
.......

==> 3

 */