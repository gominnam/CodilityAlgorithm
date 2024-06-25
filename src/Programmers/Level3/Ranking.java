package Programmers.Level3;

import java.util.*;

public class Ranking {
    static class Node{
        int idx;
        Set<Integer> win;
        Set<Integer> lose;

        public Node(int idx){
            this.idx = idx;
            this.win = new HashSet<>();
            this.lose = new HashSet<>();
        }
    }

    public static int solution(int n, int[][] results) {
        int answer = 0;
        List<Node> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new Node(i));
        }
        for(int[] result : results){
            int winner = result[0];
            int loser = result[1];
            graph.get(winner).win.add(loser);
            graph.get(loser).lose.add(winner);
        }
        for(int i=1; i<=n; i++){
            updateWinLoseList(graph, i);
            if(calculateRanking(graph, i, n)) answer++;
        }
        return answer;
    }

    public static void updateWinLoseList(List<Node> graph, int idx){
        Queue<Integer> winQueue = new LinkedList<>(graph.get(idx).win);
        Queue<Integer> loseQueue = new LinkedList<>(graph.get(idx).lose);

        while(!winQueue.isEmpty()){
            int winner = winQueue.poll();
            for(int loser : graph.get(winner).win){
                if(!graph.get(idx).win.contains(loser)){
                    graph.get(idx).win.add(loser);
                    winQueue.add(loser);
                }
            }
        }

        while(!loseQueue.isEmpty()){
            int loser = loseQueue.poll();
            for(int winner : graph.get(loser).lose){
                if(!graph.get(idx).lose.contains(winner)){
                    graph.get(idx).lose.add(winner);
                    loseQueue.add(winner);
                }
            }
        }
    }

    public static boolean calculateRanking(List<Node> graph, int idx, int n){
        return graph.get(idx).win.size() + graph.get(idx).lose.size() == n - 1;
    }

    public static void main(String[] args){
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        System.out.print(solution(n, results));
    }
}

/*
-ref: https://school.programmers.co.kr/learn/courses/30/lessons/49191?language=java

TEST CASE:
n = 5,
results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}

answer = 2


refactoring point:
1. Node 클래스의 win과 lose 리스트를 Set으로 변경 // HashSet, TreeSet
   중복된 요소를 자동으로 제거하고, contains 메서드의 시간 복잡도가 O(1)

2. 하나의 매서드를 updateWinLoseList와 calculateRanking으로 분리하여
   코드의 가독성을 높이고, 각각의 역할을 명확하게

3. 플로이드-와샬 알고리즘을 사용하여 더 간단하게 구현 가능

public class Ranking {
    public static int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] graph = new boolean[n+1][n+1];

        // 승리한 경우 추가
        for (int[] result : results) {
            graph[result[0]][result[1]] = true;
        }

        // 플로이드-와샬 알고리즘을 사용하여 각 노드 간의 승패 관계를 업데이트
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (graph[j][i] && graph[i][k]) {
                        graph[j][k] = true;
                    }
                }
            }
        }

        // 각 노드의 순위를 계산
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] || graph[j][i]) count++;
            }
            if (count == n - 1) answer++;
        }

        return answer;
    }

    public static void main(String[] args){
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        System.out.print(solution(n, results));
    }
}


--------------------------------------------------------------------

- 플로이드-와샬 알고리즘(Floyd - Warshall)
    : 모든 노드 간의 최단 경로를 구하는 알고리즘
    : 3중 for문을 사용하여 모든 노드를 순회하며 최단 경로를 업데이트
    : 시간 복잡도는 O(N^3)


++ 다익스트라(Djikstra) 비교하며 공부해볼 것
    : 하나의 시작 노드에서 다른 모든 노드로의 최단 경로를 구하는 알고리즘

 */
