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
            connectedSet.add(getParent(parents[i]));
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

    public static void main(String[] args) {
        NumberOfProvinces n = new NumberOfProvinces();
        int[][] isConnected = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(n.findCircleNum(isConnected));
    }
}

/*

Thinking:
- unionFind와 Set 자료구조를 통해서 연결된 도시의 수를 구하는 문제와 같은 유형


- ref: https://leetcode.com/problems/number-of-provinces/
 */