package Programmers.Level3;

import java.util.HashSet;
import java.util.Set;

public class Network {
    public static int[] parent;

    public int getParent(int n){
        if(parent[n] == n) return n;
        return parent[n] = getParent(parent[n]);
    }

    public int solution(int n, int[][] computers) {
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        for(int i=0; i<n; i++){
            int parentA = getParent(i+1);
            for(int j=0; j<n; j++){
                if(computers[i][j] == 0) continue;
                int parentB = getParent(j+1);
                if (parentA != parentB) {
                    parent[parentB] = parent[parentA];
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i=1; i<=n; i++){
            parent[i] = getParent(i);
            set.add(parent[i]);
        }

        return set.size();
    }

    public static void main(String[] args){
        Network network = new Network();
        int n = 5;
        int[][] computer = {{1, 1, 0, 0, 1}, {1, 1, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 1, 1, 1}, {1, 0, 0, 1, 1}};
        System.out.print(network.solution(n, computer));
    }
}
