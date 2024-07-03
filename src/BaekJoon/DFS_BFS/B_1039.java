package BaekJoon.DFS_BFS;

import java.io.*;
import java.util.*;

public class B_1039 {

    static class State {
        String num;
        int depth;

        State(String num, int depth) {
            this.num = num;
            this.depth = depth;
        }

        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return depth == state.depth && num.equals(state.num);
        }

        @Override
        public int hashCode(){
            return Objects.hash(num, depth);
        }
    }

    public static int solution(String N, int K){
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(N, 0));
        boolean[][] visited = new boolean[1000001][K+1];
        visited[Integer.parseInt(N)][0] = true;
        int max = -1;

        while(!queue.isEmpty()){
            State current = queue.poll();
            String num = current.num;
            int depth = current.depth;

            if(depth == K){
                max = Math.max(max, Integer.parseInt(num));
                continue;
            }

            int len = num.length();
            for(int i=0; i<len-1; i++){
                for(int j=i+1; j<len; j++){
                    if(i == 0 && num.charAt(j) == '0'){
                        continue;
                    }
                    String swappedNum = swap(num, i, j);
                    int swappedNumInt = Integer.parseInt(swappedNum);
                    if(visited[swappedNumInt][depth+1]){
                        continue;
                    }

                    visited[swappedNumInt][depth+1] = true;
                    queue.add(new State(swappedNum, depth+1));
                }
            }
        }

        return max;
    }

    public static String swap(String s, int i, int j){
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String N = st.nextToken();
        int K = Integer.parseInt(st.nextToken());
        bw.write(solution(N, K) + "");
        bw.flush();
        bw.close();
        br.close();}
}

/*

Thinking:

BFS/DFS 로 해결하려는 사고를 하지 못함. 단순히 정렬하여 어떻게 풀어보려함.

접근방법
1)

TEST CASE:
1)
436659 2

==> 966354

 */