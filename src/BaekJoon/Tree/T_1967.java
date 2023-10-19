package BaekJoon.Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class T_1967 {
    static ArrayList<Node>[] list;
    static int max = Integer.MIN_VALUE;
    static int maxIndex;

    public static class Node{
        int vertex;
        int distance;
        public Node(int vertex, int distance){
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            list[v1].add(new Node(v2, distance));
            list[v2].add(new Node(v1, distance));
        }
        bfs(1);
        bfs(maxIndex);
        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
    }

    public static void bfs(int start){
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[list.length];
        q.offer(new Node(start, 0));
        visited[start] = true;
        while(!q.isEmpty()){
            Node node = q.poll();
            int index = node.vertex;
            int distance = node.distance;
            if(max < distance){
                max = distance;
                maxIndex = index;
            }
            for(int i=0; i<list[index].size(); i++){
                Node n = list[index].get(i);
                if(visited[n.vertex]) continue;
                visited[n.vertex] = true;
                q.offer(new Node(n.vertex, distance+n.distance));
            }
        }
    }
}
