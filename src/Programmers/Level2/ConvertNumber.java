package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertNumber {

    public static int convertNumber(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[1000001];
        queue.offer(new int[]{x, 0});
        visited[x] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int number = current[0];
            int count = current[1];

            if (number == y) {
                return count;
            }

            if (count > y) {
                continue;
            }

            int[] nextNumbers = {number + n, number * 2, number * 3};

            for (int nextNumber : nextNumbers) {
                if (nextNumber <= 1000000 && !visited[nextNumber]) {
                    queue.offer(new int[]{nextNumber, count + 1});
                    visited[nextNumber] = true;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int x = 38;
        int y = 40;
        int n = 2;
        int answer = convertNumber(x, y, n);
        System.out.println(answer);
//       1. x에 n을 더합니다.
//       2. x에 2를 곱합니다.
//       3.  x에 3을 곱합니다.
    }
}

/*

-ref: https://school.programmers.co.kr/learn/courses/30/lessons/154538
bfs

TEST CASE:
1)
x: 10
y: 40
n: 5

answer: 2

2)
x: 10
y: 40
n: 30

answer: 1

 */