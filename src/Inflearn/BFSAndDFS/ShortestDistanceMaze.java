package Inflearn.BFSAndDFS;

import java.util.*;

public class ShortestDistanceMaze {
    static int answer = -1;
    static int[][] map = new int[8][8];
    int[] mx = {-1, 1, 0, 0};
    int[] my = {0, 0, -1, 1};

    public class Node{
        private int x;
        private int y;

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
