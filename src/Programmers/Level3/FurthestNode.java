package Programmers.Level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FurthestNode {
    public static void main(String[] args){
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(n, edge));
    }

    public static int solution(int n, int[][] edge){
        boolean[] check = new boolean[n+1];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e : edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        check[1] = true;
        int answer = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int front = queue.poll();
                for(int j : graph.get(front)){
                    if(check[j]) continue;
                    queue.add(j);
                    check[j] = true;
                }
            }
            answer = size;
        }
        return answer;
    }
}

/*
-ref: https://school.programmers.co.kr/learn/courses/30/lessons/49189
 */