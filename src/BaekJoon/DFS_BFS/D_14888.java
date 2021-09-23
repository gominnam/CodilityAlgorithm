package BaekJoon.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D_14888 {
    static int[] op = new int[4];//operator: 덧셈, 뺄셈, 곱셈, 나눗셈
    static int[] arr;
    static int N;
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] =  Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, arr[0], 0);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int L, int sum, int cnt){
        if(L == N-1 && cnt == N-1){
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for(int i=0; i<4; i++){
            if(op[i] > 0){
                --op[i];
                int ret = cal(L, i, sum);
                dfs(L+1, ret, cnt+1);
                ++op[i];
            }
        }
    }

    public static int cal(int L, int sign, int sum){//operator: 덧셈, 뺄셈, 곱셈, 나눗셈
        if(sign == 0){
            return sum + arr[L+1];
        }
        else if(sign == 1){
            return sum - arr[L+1];
        }
        else if(sign == 2){
            return sum*arr[L+1];
        }
        else{
            if(sum > 0) return sum / arr[L+1];
            else {
                int tmp = Math.abs(sum) / arr[L+1];
                return -tmp;
            }
        }
    }
}
