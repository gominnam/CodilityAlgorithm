package Inflearn.BFSAndDFS;

import java.util.*;

public class ShortestDistanceMaze {
    static int answer = -1;
    static int[][] map = new int[8][8];
    int[] mx = {-1, 1, 0, 0};
    int[] my = {0, 0, -1, 1};

    public class Node{
        public int x, y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public void solution(int L){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(new Node(1, 1));
        map[1][1] = 1;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len; i++){
                Node n = Q.poll();
                if(n.x == 7 && n.y == 7){
                    answer = L;
                    return;
                }
                for(int j=0; j<4; j++){
                    int nx = n.x + mx[j];
                    int ny = n.y + my[j];
                    if(1<= nx && nx <= 7 && 1<= ny && ny <= 7 && map[nx][ny] == 0) {
                        Q.offer(new Node(nx, ny));
                        map[nx][ny] = 1;
                    }
                }
            }
            L++;
        }
    }

    public static void main(String[] args){
        ShortestDistanceMaze T = new ShortestDistanceMaze();
        Scanner sc = new Scanner(System.in);

        for(int i=1; i<=7; i++){
            for(int j=1; j<=7; j++){
                map[i][j] = sc.nextInt();
            }
        }
        T.solution(0);
        System.out.println(answer);
    }
}
/*
미로의 최단거리 통로
설명

7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램을 작성하세요.

경로의 길이는 출발점에서 도착점까지 가는데 이동한 횟수를 의미한다.

출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 도로이다.

격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면

Image1.jpg

위와 같은 경로가 최단 경로의 길이는 12이다.


입력
첫 번째 줄부터 7*7 격자의 정보가 주어집니다.


출력
첫 번째 줄에 최단으로 움직인 칸의 수를 출력한다. 도착할 수 없으면 -1를 출력한다.

TEST CASE:
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 1 0 0 0
1 0 0 0 1 0 0
1 0 1 0 0 0 0

==> 12
 */