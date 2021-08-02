package Inflearn.BFSAndDFS;

import java.util.ArrayList;
import java.util.Scanner;

public class mazeExploration {
    static boolean[][] check = new boolean[7][7];
    static int[][] map = new int[7][7];
    int[] mx = {0, 0, 1, -1};
    int[] my = {-1, 1, 0, 0};
    static int answer = 0;

    public void solution(int x, int y){
        if(x == 6 && y == 6) answer++;
        else{
            for(int i=0; i<4; i++){
                int nx = x + mx[i];
                int ny = y + my[i];
                if(nx < 0 || nx > 6 || ny < 0 || ny > 6 || map[nx][ny] == 1 || check[nx][ny]) continue;
                check[nx][ny] = true;
                solution(nx, ny);
                check[nx][ny] = false;
            }
        }
    }

    public static void main(String[] args){
        mazeExploration T = new mazeExploration();
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++){
                map[i][j] = sc.nextInt();
            }
        }
        check[0][0] = true;
        T.solution(0, 0);
        System.out.println(answer);
    }
}
/*
feedback
==> 1. if(nx < 0 || nx > 6 || ny < 0 || ny > 6 || map[nx][ny] == 1 || check[nx][ny])에서 배열[][] 조건이 앞에 있으면 index = -1 로 에러가 난다 주의할 것(조건문 뒤에 넣을 것)
    2. check[][] 대신에 map에 1을 넣고 해도 똑같이 작동한다. (0일 경우에만 통로 지나갈 수 있으므로!!)

미로탐색
설명

7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.

출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다.

격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면

Image1.jpg

위의 지도에서 출발점에서 도착점까지 갈 수 있는 방법의 수는 8가지이다.


입력
7*7 격자판의 정보가 주어집니다.


출력
첫 번째 줄에 경로의 가지수를 출력한다.

TEST CASE:
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 0 0 0 1
1 1 0 1 1 0 0
1 0 0 0 0 0 0

==> 8

 */