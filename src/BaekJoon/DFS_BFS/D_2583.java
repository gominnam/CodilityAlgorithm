package BaekJoon.DFS_BFS;

import java.io.*;
import java.util.*;

public class D_2583 {
    static int[][] map;
    static int x, y;
    static int count = 0;
    static int[] mx = {0, 0, -1, 1};
    static int[] my = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        map = new int[y][x];
        int n = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int[] point = new int[4];
            for(int j=0; j<4; j++){
                point[j] = Integer.parseInt(st.nextToken());
            }

            for(int k=point[1]; k<point[3]; k++){//y
                for(int z=point[0]; z<point[2]; z++){//x
                    map[k][z] = 1;
                }
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                if(map[i][j] == 0){
                    count = 0;
                    DFS(i, j);
                    arr.add(count);
                }
            }
        }

        System.out.println(arr.size());
        Collections.sort(arr);
        for(int x : arr){
            System.out.print(x + " ");
        }
    }

    public static void DFS(int py, int px){
        map[py][px] = 1;
        count++;

        for(int i=0; i<4; i++){
            int ny = py + my[i];
            int nx = px + mx[i];
            if(0 <= ny && ny < y && 0 <= nx && nx < x && map[ny][nx] == 0){
                DFS(ny, nx);
            }
        }
    }
}
/*
TIP - DFS 문제

    map[y][x] 구조 파악
    앞이 높이, 뒤가 너비
 */