package Programmers.Level3;

import java.util.*;

public class ReturnToUnit {
    static final int INF = 987_654_321;

    public void bfs(int start, List<Integer>[] nodes, int[] distance){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        Arrays.fill(distance, INF);
        distance[start] = 0;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int next : nodes[cur]){
                if (distance[next] == INF) {
                    distance[next] = distance[cur] + 1;
                    queue.add(next);
                }
            }
        }
    }

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        List<Integer>[] nodes = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            nodes[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            nodes[road[0]].add(road[1]);
            nodes[road[1]].add(road[0]);
        }

        int[] distance = new int[n + 1];
        bfs(destination, nodes, distance);

        for (int i = 0; i < sources.length; i++) {
            answer[i] = (distance[sources[i]] == INF ? -1 : distance[sources[i]]);
        }

        return answer;
    }

    public static void main(String[] args){
        ReturnToUnit rtu = new ReturnToUnit();
        int n = 5;
        int[][] roads = {{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}};
        int[] sources = {1, 3, 5};
        int destination = 5;
        for(int r : rtu.solution(n, roads, sources, destination)){
            System.out.print(r + " ");
            //answer: {2, -1, 0};
        }
    }
}

/*

Thinking:

1)
Djikstra 로 문제를 푼 경우 시간초과 발생.
sources 만큼 dijkstra 알고리즘을 사용하여서 생긴 오류

=> 가중치가 일치하고 양방향 간선인 경우 BFS로 한번에 처리 가능.




-ref: https://school.programmers.co.kr/learn/courses/30/lessons/132266

 */