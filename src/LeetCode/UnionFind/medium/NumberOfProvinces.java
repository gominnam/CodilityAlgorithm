package LeetCode.UnionFind.medium;

import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces {

    int[] parents;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parents = new int[n];

        for(int i=0; i<n; i++){
            parents[i] = i;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<isConnected[0].length; j++){
                if(isConnected[i][j] == 1){
                    unionFind(i, j);
                }
            }
        }

        Set<Integer> connectedSet = new HashSet<>();
        for(int i=0; i<n; i++){
            connectedSet.add(getParent(i));
        }

        return connectedSet.size();
    }

    public int getParent(int n){
        if(parents[n] == n) return n;
        return getParent(parents[n]);
    }

    public void unionFind(int i, int j){
        int a = getParent(i);
        int b = getParent(j);
        if(a <= b) parents[b] = a;
        else parents[a] = b;
    }

    public int findCircleNum_dfs(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                cnt++;
            }
        }

        return cnt;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int from) {
        visited[from] = true;

        for (int i = 0; i < isConnected[from].length; i++) {
            if (from != i && isConnected[from][i] == 1 && !visited[i]) {
                dfs(isConnected, visited, i);
            }
        }
    }


    public static void main(String[] args) {
        NumberOfProvinces n = new NumberOfProvinces();
        int[][] isConnected = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(n.findCircleNum(isConnected));
    }
}

/*

Thinking:
- unionFind와 Set 자료구조를 통해서 연결된 도시의 수를 구하는 문제와 같은 유형(시간복잡도 O(N^2))
- finCircleNum_dfs는 dfs를 통해서 시간복잡도와 메모리 최적화 (시간복잡도 O(N + E))


- ref: https://leetcode.com/problems/number-of-provinces/
 */