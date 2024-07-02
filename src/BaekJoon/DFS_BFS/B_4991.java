package BaekJoon.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class B_4991 {
    static int W, H;
    static int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int cleaningMask;
        int moveCnt;

        Node(int x, int y, int cleaningMask, int moveCnt){
            this.x = x;
            this.y = y;
            this.cleaningMask = cleaningMask;
            this.moveCnt = moveCnt;
        }

        @Override
        public int compareTo(Node n){
            return Integer.compare(this.moveCnt, n.moveCnt);
        }
    }

    public static int bfs(char[][] map, Node start, List<Node> trash){
        int trashCnt = trash.size();
        int[][][] visited = new int[H][W][1 << trashCnt]; // trashCnt가 3인경우 2^3(=8)만큼의 경우의 수가 있음.
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(start);
        visited[start.x][start.y][0] = 1;

        while(!pq.isEmpty()){
            Node n = pq.poll();
            int curX = n.x;
            int curY = n.y;

            if(n.cleaningMask == (1 << trashCnt) - 1){
                return n.moveCnt;
            }

            for(int i=0; i<4; i++){
                int nx = curX + dir[i][0];
                int ny = curY + dir[i][1];
                int curCleaningMask = n.cleaningMask;

                if(nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == 'x'){
                    continue;
                }

                for(int j=0; j<trashCnt; j++){
                    Node trashNode = trash.get(j);
                    if(nx == trashNode.x && ny == trashNode.y){
                        curCleaningMask |= (1 << j); // trashCnt가 3인 경우 1, 2, 4 (비트로 111)
                    }
                }

                if(visited[nx][ny][curCleaningMask] == 0){ // 현재 청소 상태에 따라 방문 여부
                    visited[nx][ny][curCleaningMask] = 1;
                    pq.add(new Node(nx, ny, curCleaningMask, n.moveCnt + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] input = br.readLine().split(" ");
            W = Integer.parseInt(input[0]);
            H = Integer.parseInt(input[1]);
            if(W == 0 && H == 0){
                break;
            }

            char[][] map = new char[H][W];
            Node start = null;
            List<Node> trashList = new ArrayList<>();
            for(int i=0; i<H; i++){
                char[] m = br.readLine().toCharArray();
                for(int j=0; j<W; j++){
                    map[i][j] = m[j];
                    if(m[j] == '*'){
                        trashList.add(new Node(i, j, 0, 0));
                    }
                    else if(m[j] == 'o'){
                        start = new Node(i, j, 0, 0);
                    }
                }
            }
            System.out.println(bfs(map, start, trashList));
        }
    }
}

/*

Thinking:
완전탐색을 하더라도 청소 내역을 관리하는데 어려움
비트마스킹으로 각각의 위치 청소 여부 관리
ex) 1 << n  // n만큼 왼쪽으로 비트를 이동 (2^n 만큼 곱한 값과 같다)
    4 >> 2  // >> 는 반대로 2^2 만큼 나눈 값이 된다. 즉, 결과값은 1
    1010 | 1000 // |은 OR 연산자로 비트중 하나라도 1이면 1을 반환한다. ex) 1010
    1010 & 1000 // &는 AND 연산자로 비트중 두 비트가 모두 1이여야 1을 반환한다. ex) 1000

TEST CASE:
1)
7 5
.......
.o...*.
.......
.*...*.
.......
15 13
.......x.......
...o...x....*..
.......x.......
.......x.......
.......x.......
...............
xxxxx.....xxxxx
...............
.......x.......
.......x.......
.......x.......
..*....x....*..
.......x.......
10 10
..........
..o.......
..........
..........
..........
.....xxxxx
.....x....
.....x.*..
.....x....
.....x....
0 0

==>
8
49
-1


 */