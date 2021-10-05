package Programmers.Level2;

import java.util.PriorityQueue;

public class JumpTeleport {

    public static void main(String[] args){
        int n = 5;
        int ans = 0;
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(1, 1));
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.cur == n) {
                break;
                //return node.value;
            }
            for(int i=0; i<2; i++){
                if(node.cur * 2 <= n) q.add(new Node(node.cur*2, node.value));
                if(node.cur + 1 <= n) q.add(new Node(node.cur+1, node.value+1));
            }
        }
    }

    static class Node implements Comparable<Node>{
        int cur, value;
        public Node(int c, int v){
            this.cur = c;
            this.value = v;
        }

        @Override
        public int compareTo(Node n){
            return this.value - n.value;
        }
    }
}
/*
    #DP 문제

   feedback - 처음에 bfs로 문제를 풀어서 시간초과와 메모리 초과가 발생했다.


 */