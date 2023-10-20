package BaekJoon.Tree;

import java.io.*;
import java.util.ArrayList;

public class T_1068 {
    static boolean visited[];
    static ArrayList<Integer>[] list;
    static int root;
    static int leafCount = 0;

    public static void dfs(int start){
        boolean isLeaf = true;
        visited[start] = true;
        for(Integer i : list[start]){
            if(visited[i]) continue;
            isLeaf = false;
            dfs(i);
        }
        if(isLeaf) leafCount++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        list = new ArrayList[n];
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
        }
        String[] str = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            int v = Integer.parseInt(str[i]);
            if(v == -1) {
                root = i;
                continue;
            }
            list[i].add(v);
            list[v].add(i);
        }
        int removeNodeIndex = Integer.parseInt(br.readLine());
        visited[removeNodeIndex] = true;
        if(!visited[root]) dfs(root);
        sb.append(leafCount);
        bw.write(sb.toString());
        bw.flush();
    }
}
/*
Question: count leaf excluding removed node
answer: bfs algorithm

TEST_CASE:
9
-1 0 0 2 2 4 4 6 6
4

==>
2

 */