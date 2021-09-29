package BaekJoon.Etc;

import java.io.*;
import java.util.*;

public class Kruskal_1197 {
    static int[] parent;

    static class Node implements Comparable<Node>{
        int start;
        int end;
        int weight;
        public Node(int s, int e, int w){
            this.start = s;
            this.end = e;
            this.weight = w;
        }
        public int compareTo(Node n){
            return this.weight - n.weight;
        }
    }

    public static int getParent(int a){
        if(a == parent[a]) return a;
        return parent[a] = getParent(parent[a]);//실수한 부분 update 해줘야함
    }

    public static boolean findParent(int a, int b){
        if(getParent(a) == getParent(b)) return true;
        return false;
    }

    public static void unionParent(int a, int b){//<---- 여기 실수로 실패
        int p1 = getParent(a);
        int p2 = getParent(b);
        if(p1 < p2) parent[p2] = p1; //실수 부분!!
        else parent[p1] = p2;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());//정점 개수
        int E = Integer.parseInt(st.nextToken());//간선 개수
        parent = new int[V+1];
        for(int i=1; i<=V; i++){//0부터 했음
            parent[i] = i;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.add(new Node(start, end, weight));
        }
        int ans = 0;
        while(!pq.isEmpty()){
            Node n = pq.poll();
            if(!findParent(n.start, n.end)){
                unionParent(n.start, n.end);
                ans += n.weight;
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
