package BaekJoon.Tree;

import java.io.*;
import java.util.*;

public class T_1167 {
    static ArrayList<Node>[] list;
    static int max = Integer.MIN_VALUE;
    static int maxIndex = 1;

    public static class Node{
        int index;
        int distance;
        public Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while(true){
                int to = Integer.parseInt(st.nextToken());
                if(to == -1) break;
                int distance = Integer.parseInt(st.nextToken());
                list[from].add(new Node(to, distance));
            }
        }

        bfs(1);
        bfs(maxIndex);
        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void bfs(int start){
        boolean[] visited = new boolean[list.length];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, 0));
        visited[start] = true;
        while(!q.isEmpty()){
            Node node = q.poll();
            int index = node.index;
            int distance = node.distance;
            if(distance > max){
                max = distance;
                maxIndex = index;
            }
            for(Node n : list[index]){
                if(!visited[n.index]){
                    visited[n.index] = true;
                    q.offer(new Node(n.index, distance+n.distance));
                }
            }
        }
    }
}

/*
TEST CASE:
5
1 3 2 -1
2 4 4 -1
3 1 2 4 3 -1
4 2 4 3 3 5 6 -1
5 4 6 -1

==>
11


#, FeedBack
1. time complexity: O(n^2) -> O(n)
=> 처음에 bfs로 구현하니 시간초과 문제가 발생. >> 하나의 정점에서 최대 지름을 구한 index에서 다시 bfs를 돌려서 최대 지름을 구함. (2회만 돌리면 된다)

2. 입력값이 순서대로 들어올 것으로 주관적인 생각으로 하드코딩하여 실패
token을 이용하여 입력값을 받아오는 것이 더 확실하다.
 */