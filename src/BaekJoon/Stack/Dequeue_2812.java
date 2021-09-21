package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dequeue_2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        String number = br.readLine();
        char[] split = number.toCharArray();

        Deque<Character> largest = new ArrayDeque<>();

        for(char i : split){
            while(!largest.isEmpty() && K>0 && largest.getLast() < i){ // 다음 값이 크다 -> 앞의 값을 지우는 게 낫다
                largest.removeLast();
                K--;
            }
            largest.addLast(i);
        }

        StringBuilder answer = new StringBuilder();
        while(largest.size()>K){        // 만약 모든 숫자를 돌았음에도 불구하고 K가 남아있을 경우 대비
            answer.append(largest.removeFirst());
        }
        System.out.println(answer);
    }

}
