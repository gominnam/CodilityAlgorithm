package BaekJoon.Simulation;

import java.io.*;
import java.util.*;

public class B_16234 {
    static int[][] map;
    static int[][] visit;//국경선: border Line, false 면 국경선이 닫힌 것
    static int N, L, R, count = 0;
    static int[] mY = {-1, 1, 0, 0};
    static int[] mX = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(solve() + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve(){
        int ret = 0;//결과 일
        boolean flag;

        do{
            flag = false;
            visit = new int[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(visit[i][j] == 0){
                        count = 0;
                        int sum = find(i, j, -1);
                        if(count > 1){
                            flag = true;
                            move(i, j, sum/count);
                        }
                        else{
                            visit[i][j] = 2;
                        }
                    }
                }
            }
            if(flag) ++ret;
        } while(flag);

        return ret;
    }

    public static int find(int row, int col, int val){//열, 행, 이전 노드 값
        if(row < 0 || row >= N || col < 0 || col >= N) return 0;
        if(visit[row][col] != 0) return 0;

        if(val != -1){//정점일 때만 -1
            int dif = Math.abs(val - map[row][col]);
            if(dif < L || dif > R) return 0;
        }

        visit[row][col] = 1;//방문 chk
        count++;
        int sum = map[row][col];
        for(int i=0; i<4; i++){
            int nY = row + mY[i];
            int nX = col + mX[i];
            sum += find(nY, nX, map[row][col]);
        }

        return sum;
    }

    static void move(int row, int  col, int val){
        if(row < 0 || row >= N || col < 0 || col >= N) return;
        if(visit[row][col] != 1) return;

        visit[row][col] = 2;
        map[row][col] = val;
        for(int i=0; i<4; i++){
            int nY = row + mY[i];
            int nX = col + mX[i];
            move(nY, nX, val);
        }
    }
}
/*
인구이동 - 시뮬레이션(BFS)

1. 국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
2. 연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.

    #, 구현
    - 국경선을 체크한다.(인구수 확인)
    - 열린 국경선 인구이동 계산후 값 넣기



    //2차원배열 채우는 방법 forEach문 사용하기
    for (int[] m : map)
        Arrays.fill(m, 10);

 */
