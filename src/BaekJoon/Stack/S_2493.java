package BaekJoon.Stack;

import java.io.*;
import java.util.*;

public class S_2493 {
    public static class Tower{
        int height;
        int pos;
        public Tower(int h, int p){
            this.height = h;
            this.pos = p;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        Stack<Tower> stack = new Stack<>();

        for(int i=1; i<=N; i++){
            if(stack.isEmpty()) {
                stack.push(new Tower(Integer.parseInt(st.nextToken()), i));
                sb.append("0 ");
            }
            else {
                int curHeight = Integer.parseInt(st.nextToken());
                while(!stack.isEmpty() && stack.peek().height < curHeight){
                    stack.pop();
                }

                if(stack.isEmpty()){
                    sb.append("0 ");
                }
                else {
                    sb.append(stack.peek().pos + " ");
                }

                stack.push(new Tower(curHeight, i));
            }
        }

        System.out.println(sb);
    }
}
/*
타워 레이저 수신
TIP - 1. Stack 자료구조를 사용하여 자신보다 낮을경우 pop, 높을경우 높은 타워의 인덱스 값을 넣고 자신 또한 push

 */
