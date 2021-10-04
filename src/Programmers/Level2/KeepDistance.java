package Programmers.Level2;

import java.util.*;

class Node{
    int y, x;
    Node(int y, int x){
        this.y = y;
        this.x = x;
    }
}

public class KeepDistance {
    static int[] mx = {0, 0, -1, 1};
    static int[] my = {-1, 1, 0, 0};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i=0; i<5; i++){
            answer[i] = confirm(places[i]);
        }

        return answer;
    }

    public static int confirm(String[] str){
        char[][] map = new char[5][5];
        for(int i=0; i<str.length; i++){
            for(int j=0; j<str[i].length(); j++){
                map[i][j] = str[i].charAt(j);
            }
        }

        for(int i=0; i<map.length; i++){
            for(int j=0; j<map.length; j++){
                if(map[i][j] == 'P') {
                    if(bfs(map, i, j)) continue;
                    else return 0;
                }
            }
        }

        return 1;
    }

    public static boolean bfs(char[][] map, int y, int x){
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        q.add(new Node(y, x));
        visited[y][x] = true;

        while(!q.isEmpty()){
            Node n = q.poll();
            for(int i=0; i<4; i++){
                int ny = n.y + my[i];
                int nx = n.x + mx[i];
                int mht = Math.abs(ny - y) + Math.abs(nx - x);
                if(ny < 0 || ny > 4 || nx < 0 || nx > 4 || visited[ny][nx] || mht > 2) continue;

                visited[ny][nx] = true;
                if(map[ny][nx] == 'P') return false;
                else if(map[ny][nx] == 'X') continue;
                else q.add(new Node(ny, nx));

            }
        }
        return true;
    }

    public static void main(String[] args){
        KeepDistance T = new KeepDistance();
        Scanner sc = new Scanner(System.in);

        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        for(int x : T.solution(places)){
            System.out.print(x + " ");
        }
    }
}

/*
거리두기 확인하기
 */
