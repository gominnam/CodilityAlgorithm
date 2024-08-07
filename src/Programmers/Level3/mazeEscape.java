package Programmers.Level3;

import java.util.*;

public class mazeEscape {

    //d l r u : dictionary sort
    static int[][] move = new int[][]{ {1, 0}, {0, -1}, {0, 1}, {-1, 0} };
    static char[] directions = {'d', 'l', 'r', 'u'};
    static List<String> answers = new ArrayList<>();
    static List<String> answerDFS = new ArrayList<>();

    class Node {
        int x;
        int y;
        int count;
        String statement;

        public Node(int x, int y, int c, String s) {
            this.x = x;
            this.y = y;
            this.count = c;
            this.statement = s;
        }
    }

    public void bfs(int[] start, char[][] map, int k){
        int n = map.length;
        int m = map[0].length;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start[0], start[1], 0, ""));
        Set<String> visited = new HashSet<>();

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            int curCount = cur.count;
            String curStatement = cur.statement;

            if(curCount > k) return;
            if(curCount == k && map[x][y] == 'E'){
                answerDFS.add(curStatement);
                return;
            }

            for(int i=0; i<4; i++){
                StringBuilder sb = new StringBuilder(curStatement);
                StringBuilder visit = new StringBuilder();
                sb.append(indexToChar(i));
                int mx = x + move[i][0];
                int my = y + move[i][1];
                visit.append(mx).append(",").append(my).append(",").append(curCount+1);

                if(mx < 0 || mx >= n || my < 0 || my >= m || visited.contains(visit.toString())) continue;

                visited.add(visit.toString());
                queue.add(new Node(mx, my, curCount + 1, sb.toString()));
            }
        }
    }

    public void dfs(int[] start, char[][] map, int k, int x, int y, int count, String statement){
        if(count > k) return;
        if(count == k && map[x][y] == 'E'){
            answers.add(statement);
            return;
        }

        for(int i=0; i<4; i++){
            StringBuilder sb = new StringBuilder(statement);
            StringBuilder visit = new StringBuilder();
            sb.append(indexToChar(i));
            int mx = x + move[i][0];
            int my = y + move[i][1];
            visit.append(mx).append(",").append(my).append(",").append(count+1);

            if(mx < 0 || mx >= map.length || my < 0 || my >= map[0].length) continue;
            if(!answers.isEmpty()) return;

            dfs(start, map, k, mx, my, count+1, sb.toString());
        }
    }

    public char indexToChar(int i){
        if(i == 0) return 'd';
        else if(i == 1) return 'l';
        else if(i == 2) return 'r';
        else return 'u';
    }

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        // initialization map
        char[][] map = new char[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = '.';
            }
        }
        map[x-1][y-1] = 'S';
        map[r-1][c-1] = 'E';

        int[] start = new int[]{ x-1, y-1 };
        bfs(start, map, k);
        dfs(start, map, k, x-1, y-1, 0, "");

        if(answers.isEmpty()) return "impossible";
        return answers.get(0) + ", "+ answerDFS.get(0);
    }

    public static void main(String[] args){
        mazeEscape mazeEscape = new mazeEscape();
        System.out.println(mazeEscape.solution(3, 4, 2, 3, 3,1, 5));
    }
}

/*

Thinking:
1) BFS
- Cache인 visited를 사용하지 않았을 때 시간 초과 발생

2) String 의 HashSet 자료구조로 방문 여부 체크하여 해결

3) dfs 로 하는 경우 캐쉬가 필요 없다 재귀로 사전순으로 실행함

-ref: https://school.programmers.co.kr/learn/courses/30/lessons/150365

 */
