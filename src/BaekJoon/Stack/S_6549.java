package BaekJoon.Stack;

import java.io.*;
import java.util.*;

public class S_6549 {
    static int[] histogram;

    public static void main(String[] args) throws NumberFormatException, IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N;
        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            histogram = new int[N];
            if(N == 0) break;
            for(int i=0; i<N; i++){
                histogram[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(getArea(N)).append('\n');
            histogram = null;
        }
        System.out.println(sb);
    }

    public static long getArea(int len){
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;
        for(int i=0; i<len; i++){
            //이전 체인의 높이보다 현재 높이가 작거나 같은 경우 이전 체인들의 index를 pop하면서 최대값을 구한다.
            while(!stack.isEmpty() && histogram[stack.peek()] > histogram[i]) {
                long height = histogram[stack.pop()];
                long width = stack.isEmpty() ? i : i - 1 - stack.peek();

                maxArea  = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            long height = histogram[stack.pop()];
            long width = stack.isEmpty() ? len : len - 1 - stack.peek();//비어 있다는 것은 현재 높이가 가장 낮은 경우
            maxArea  = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}
/*
현재 풀이방식 : STACK
히스토그램(가장 넓은 직사각형 넓이 구하기)

TIP : 1. 분할 정복 알고리즘(Divide and conquer algorithm) // 재귀 오버헤드 이슈로 속도 문제
      2. Stack, Queue 등의 자료구조를 통해 빠른실행, 부문제 해결 순서 선택을 통해 분할정복법을 구현할 수 있다.
      3. SegmentTree를 통한 방법(가장 낮은 막대 높이를 통하여 넓이를 구해가는 방식)

solution - 히스토그램에서 가장 높이가 낮은 막대
         -
 */