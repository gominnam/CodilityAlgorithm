package Inflearn.BFSAndDFS;

import java.util.*;

public class IslandCountry {
    static int n, answer = 0;
    static int[][] map = new int[21][21];
    static int[] mx = {0, 0, 1, -1, -1, 1, -1, 1};
    static int[] my = {-1, 1, 0, 0, -1, -1, 1, 1};
    static Queue<Point> Q = new LinkedList<>();

    public class Point{
        int x, y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public void solution(int x, int y){//BFS
        Q.offer(new Point(x, y));
        map[x][y] = 0;
        while(!Q.isEmpty()){
            Point p = Q.poll();
            for(int j=0; j<8; j++){
                int nx = p.x + mx[j];
                int ny = p.y + my[j];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 1){
                    Q.offer(new Point(nx, ny));
                    map[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args){
        IslandCountry T = new IslandCountry();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1) {
                    T.solution(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
/*
feedback - 대각선도 포함이므로 8방향 check // DFS, BFS 둘다 가능하므로 둘다 해볼 것
         - solution에서 int len = Q.size(); 부분 생략해도 된다. Level check 할때 할 것

설명

N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.

각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.

섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.

Image1.jpg

만약 위와 같다면 섬의 개수는 5개입니다.


입력
첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다.

두 번째 줄부터 격자판 정보가 주어진다.


출력
첫 번째 줄에 섬의 개수를 출력한다.


TEST CASE:
7
1 1 0 0 0 1 0
0 1 1 0 1 1 0
0 1 0 0 0 0 0
0 0 0 1 0 1 1
1 1 0 1 1 0 0
1 0 0 0 1 0 0
1 0 1 0 1 0 0

==> 5
 */
