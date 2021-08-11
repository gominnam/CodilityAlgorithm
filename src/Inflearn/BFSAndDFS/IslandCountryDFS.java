package Inflearn.BFSAndDFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IslandCountryDFS {
    static int n, answer = 0;
    static int[][] map = new int[21][21];
    static int[] mx = {0, 0, 1, -1, -1, 1, -1, 1};
    static int[] my = {-1, 1, 0, 0, -1, -1, 1, 1};

    public void solution(int x, int y){//DFS
        for(int i=0; i<8; i++){
            int nx = x+mx[i];
            int ny = y+my[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 1){
                map[nx][ny] = 0;
                solution(nx, ny);
            }
        }
    }

    public static void main(String[] args){
        IslandCountryDFS T = new IslandCountryDFS();
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
                    map[i][j] = 0;
                    T.solution(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
/*
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