package BaekJoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D_2933 { // todo: fix not yet solved
    static int R, C;
    static char[][] map;
    static boolean[][] visited, floatingCluster;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void throwStickFromLeft(int height){
        for(int i=0; i<C; i++){
            if(map[R - height][i] == 'x'){
                map[R - height][i] = '.';
                return;
            }
        }
    }

    public static void throwStickFromRight(int height){
        for(int i=C-1; i>=0; i--){
            if(map[R - height][i] == 'x'){
                map[R - height][i] = '.';
                return;
            }
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                continue;
            }

            if (map[nx][ny] == 'x' && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }

    public static void makeFloatingCluster(int x, int y){
        floatingCluster[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(nx < 0 || ny < 0 || nx >= R || ny >= C){
                continue;
            }

            if(map[nx][ny] == 'x' && !floatingCluster[nx][ny]){
                makeFloatingCluster(nx, ny);
            }
        }
    }

    public static void dropCluster(int dropDistance){
        if (dropDistance == 0) return;

        for (int row = R - 1; row >= 0; row--) {
            for (int col = 0; col < C; col++) {
                if (floatingCluster[row][col]) {
                    map[row + dropDistance][col] = 'x';
                    map[row][col] = '.';
                }
            }
        }
    }

    public static int calculateDropDistance(){
        int minDistance = Integer.MAX_VALUE;

        for (int col = 0; col < C; col++) {
            int maxFloating = -1; // 떠 있는 클러스터의 가장 낮은 부분
            int minSolid = R; // 고정된 클러스터의 가장 높은 부분

            for (int row = 0; row < R; row++) {
                if (floatingCluster[row][col]) {
                    maxFloating = row;
                } else if (map[row][col] == 'x') {
                    minSolid = row;
                    break; // 고정된 클러스터를 찾았으므로 더 이상 위로 올라갈 필요가 없습니다.
                }
            }

            if (maxFloating != -1) { // 떠 있는 클러스터가 있는 경우
                minDistance = Math.min(minDistance, minSolid - maxFloating - 1);
            }
        }

        return minDistance == Integer.MAX_VALUE ? 0 : minDistance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]); //row
        C = Integer.parseInt(input[1]); //col
        map = new char[R][C];
        for(int i=0; i<R; i++){
            String str = br.readLine();
            for(int j=0; j<str.length(); j++){
                map[i][j] = str.charAt(j);
            }
        }
        int N = Integer.parseInt(br.readLine());
        // 막대기 던지기
        String[] caveHeights = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            int caveHeight = Integer.parseInt(caveHeights[i]); // col index
            if(i % 2 == 0) {
                throwStickFromLeft(caveHeight);
            }
            else {
                throwStickFromRight(caveHeight);
            }

            visited = new boolean[R][C];
            for(int y = 0; y < C; y++){
                if(map[R-1][y] == 'x' && !visited[R-1][y]){
                    dfs(R-1, y);
                }
            }

            floatingCluster = new boolean[R][C];
            for(int x=0; x<R; x++){
                for(int y=0; y<C; y++){
                    if(map[x][y]=='x' && !visited[x][y]){
                        makeFloatingCluster(x, y);
                    }
                }
            }
            int dropDistance = calculateDropDistance();
            dropCluster(dropDistance);
        }

        //print
        for (int i = 0; i < R; i++) {
            System.out.println(map[i]);
        }
    }
}
/*
Thinking:

풀이과정: n번의 화살 쏘기 만큼 1) ~ 4) 로직의 loop를 반복

1) Arrow Throwing(화살 쏘기)
2) BFS 또는 DFS 로 바닥에 연결된 cluster 데이터 저장
3) isFloating 매서드로 미네랄이 떨어질 수 있는지 확인
4) 3)에서 true가 반환되면 dropCluster 매서드를 호출하여 drop 로직 수행


TEST CASE:
1)
5 6
......
..xx..
..x...
..xx..
.xxxx.
1
3

==>
......
......
..xx..
..xx..
.xxxx.

2)
8 8
........
........
...x.xx.
...xxx..
..xxx...
..x.xxx.
..x...x.
.xxx..x.
5
6 6 4 3 1

==>
........
........
........
........
.....x..
..xxxx..
..xxx.x.
..xxxxx.


3)
9 8
........
...xxx..
.xxx....
.x.x.xxx
.x.x...x
.x.xxx.x
.x.....x
.x.....x
.xxx...x
1
7

==>
........
........
...xxx..
.xxx.xxx
.x.x...x
.x.x...x
.x.xxx.x
.x.....x
.xxx...x


4)
7 5
.....
.xxx.
.x...
xx.xx
x...x
x...x
x...x
1
4

==>
.....
.....
.xxx.
.x.xx
xx..x
x...x
x...x



//
3 8
...xxxxx
...xx...
...xx...
4
1 1 1 1



*/

