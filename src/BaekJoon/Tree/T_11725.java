package BaekJoon.Tree;

import java.io.*;
import java.util.ArrayList;

public class T_11725 {
    public static int[] parent;
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void dfs(int x){
        visited[x] = true;
        for(int i : list.get(x)){
            if(!visited[i]){
                parent[i] = x;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        visited = new boolean[n+1];
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        for(int i=1; i<n; i++){
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            list.get(a).add(b);
            list.get(b).add(a);
        }
        dfs(1);
        for(int i=2;i<=n; i++){
            sb.append(parent[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

/*

TEST CASE:

7
1 6
6 3
3 5
4 1
2 4
4 7

==>
4
6
1
3
1
4


 */