package LeetCode.UnionFind.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfIslandsII {

    final static int[][] mv = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    Set<Integer> islandSet;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] islands = new int[m][n];
        islandSet = new HashSet<>();
        List<Integer> answer = new ArrayList<>();

        for(int i=1; i<=positions.length; i++){
            int row = positions[i-1][0];
            int col = positions[i-1][1];
            islands[row][col] = i;

            int[] island = new int[2];
            int checkNum = Integer.MAX_VALUE;
            for(int[] move : mv){
                int nr = row + move[0];
                int nc = col + move[1];
                if(nr < 0 || nc < 0 || nr >= m || nc >= n || islands[nr][nc] == 0) continue;
                if(islands[nr][nc] < checkNum){
                    checkNum = islands[nr][nc];
                    island[0] = nr;
                    island[1] = nc;
                }
            }

            if(checkNum == Integer.MAX_VALUE){
                islandSet.add(i);
            } else {
                dfs(islands, island[0], island[1], checkNum);
            }
            answer.add(islandSet.size());
        }

        return answer;
    }

    void dfs(int[][] islands, int row, int col, int val){
        int m = islands.length;
        int n = islands[0].length;
        islands[row][col] = val;
        for(int[] move : mv){
            int nr = row + move[0];
            int nc = col + move[1];
            if(nr < 0 || nc < 0 || nr >= m || nc >= n || islands[nr][nc] == 0 || islands[nr][nc] == val) continue;
            islandSet.remove(islands[nr][nc]);
            dfs(islands, nr, nc, val);
        }
    }

    int[] parent;
    int[] rank;

    public List<Integer> numIslands2_gpt(int m, int n, int[][] positions) {
        parent = new int[m * n];
        rank = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            parent[i] = -1;
            rank[i] = 0;
        }

        List<Integer> answer = new ArrayList<>();
        int count = 0;

        for (int[] pos : positions) {
            int row = pos[0];
            int col = pos[1];
            int index = row * n + col;

            if (parent[index] != -1) {
                answer.add(count);
                continue;
            }

            parent[index] = index;
            count++;

            for (int[] move : mv) {
                int nr = row + move[0];
                int nc = col + move[1];
                int newIndex = nr * n + nc;

                if (nr >= 0 && nc >= 0 && nr < m && nc < n && parent[newIndex] != -1) {
                    int root1 = find(index);
                    int root2 = find(newIndex);

                    if (root1 != root2) {
                        union(root1, root2);
                        count--;
                    }
                }
            }
            answer.add(count);
        }

        return answer;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public static void main(String[] args) {
        NumberOfIslandsII numberOfIslandsII = new NumberOfIslandsII();
        int m = 3;
        int n = 3;
        int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};
        System.out.println(numberOfIslandsII.numIslands2(m, n, positions)); // [1, 1, 2, 3]
        positions = new int[][]{{0, 1}, {1, 2}, {2, 1}, {1, 0}, {0, 2}, {0, 0}, {1, 1}};
        System.out.println(numberOfIslandsII.numIslands2(m, n, positions)); // [1, 2, 3, 4, 3, 2, 1]
        m = 8;
        n = 10;
        positions = new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}, {2, 2}, {1, 1}, {3, 4}, {3, 5}, {4, 5}, {4, 4}, {5, 5}, {6, 6}, {7, 7}, {7, 6}, {6, 7}, {5, 6}}; // [1, 1, 2, 3, 2, 1, 2, 2, 2, 2, 2, 3, 4, 3, 3, 2]
        System.out.println(numberOfIslandsII.numIslands2(m, n, positions));

        System.out.println(numberOfIslandsII.numIslands2_gpt(m, n, positions));
        System.out.println(numberOfIslandsII.numIslands2_gpt(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}})); // [1, 1, 2, 3]
    }
}

/*

Thinking:
- islands 2차원 배열을 생성하고 positon 위치에 방향성이 있는 오름차순 숫자를 입력
- 좌우상하에 섬이 있는지 체크하고 있는 경우에 낮은 숫자를 dfs를 사용하여 update
- update 하는 동안 set 기존 값 제거(섬이 합쳐지므로)
- set size를 answer에 추가

-ref : https://leetcode.com/problems/number-of-islands-ii/

 */