package Programmers.Level3;

public class WayToSchool {
    static int[][] map;

    public int dp(int x, int y){
        if(x < 0 || y < 0 || map[y][x] == -1) return 0;
        if(x == 0 && y == 0) return 1;
        if(map[y][x] > 0) return map[y][x];
        return map[y][x] = (dp(x, y-1) + dp(x-1, y))%1000000007;
    }

    public int solution(int m, int n, int[][] puddles) {//x:m, y:n
        map = new int[n][m];
        for(int i=0; i<puddles.length; i++){
            map[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }
        return dp(m-1, n-1);
    }

    public static void main(String[] args){//m = x, n = y
        WayToSchool wts = new WayToSchool();
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};
        System.out.println(wts.solution(m, n, puddles));
    }
}
