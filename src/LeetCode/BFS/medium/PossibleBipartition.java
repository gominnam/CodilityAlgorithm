package LeetCode.BFS.medium;

import java.util.*;

public class PossibleBipartition {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }

        int[] colors = new int[n + 1]; // 0: not colored, 1: red, -1: blue
        for (int i = 1; i <= n; i++) {
            if (colors[i] == 0) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                colors[i] = 1; // Start coloring with red

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int neighbor : graph[node]) {
                        if (colors[neighbor] == 0) {
                            colors[neighbor] = -colors[node]; // Color with opposite color
                            queue.add(neighbor);
                        } else if (colors[neighbor] == colors[node]) {
                            return false; // Same color on both sides, not bipartite
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PossibleBipartition p = new PossibleBipartition();
        int N = 5;
        int[][] dislikes = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        System.out.println(p.possibleBipartition(N, dislikes)); // true
    }
}

/*

Thinking:
- int[] 배열 2개로 grouping 하여 그리디 형식은 Wrong Answer
- 소스 참고하여 BFS, UnionFind 해결코드 작성  // todo: unionFind

 */