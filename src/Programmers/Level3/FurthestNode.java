package Programmers.Level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FurthestNode {
    public class Node{
        int n;
        ArrayList<Integer> connect;
        public Node(int n){
            this.n = n;
            connect = new ArrayList<>();
        }
    }
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] check = new boolean[n+1];
        ArrayList<Node> nodes = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<=n; i++){
            nodes.add(new Node(n));
        }
        for(int i=0; i<edge.length; i++){
            nodes.get(edge[i][0]).connect.add(edge[i][1]);
            nodes.get(edge[i][1]).connect.add(edge[i][0]);
        }
        queue.add(1);
        check[1] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            answer = size;
            for(int i=0; i<size; i++){
                int front = queue.poll();
                for(int j=0; j<nodes.get(front).connect.size(); j++){
                    int conValue = nodes.get(front).connect.get(j);
                    if(check[conValue]) continue;
                    queue.add(conValue);
                    check[conValue] = true;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        FurthestNode fn = new FurthestNode();
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(fn.solution(n, edge));
    }
}
