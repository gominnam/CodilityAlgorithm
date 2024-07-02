package BaekJoon.DP;

import java.io.*;
import java.util.StringTokenizer;

public class DP_10942 {

    static int[][] dp = new int[2001][2001];

    public static void palindromeCalculator(int N, int[] nums){
        // 모든 길이가 1인 구간은 팰린드롬
        for (int i = 1; i <= N; i++) {
            dp[i][i] = 1;
        }

        // 길이가 2인 구간
        for (int i = 1; i < N; i++) {
            if (nums[i] == nums[i+1]) {
                dp[i][i+1] = 1;
            }
        }

        // 길이가 3 이상인 구간
        for (int length = 3; length <= N; length++) {
            for (int i = 1; i <= N - length + 1; i++) {
                int j = i + length - 1;
                if (nums[i] == nums[j] && dp[i+1][j-1] == 1) {
                    dp[i][j] = 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        palindromeCalculator(N, nums);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            sb.append(dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

/*

Thinking:
Two Pointer로 제출하면 시간초과 발생
System.out.print() 대신에 BufferedWriter를 사용하여 시간초과 문제 해결


#1) BufferedWriter
: 내부적으로 버퍼를 사용하여 출력 데이터를 임시 저장.
  실제 출력 장치(예: 디스크, 네트워크 스트림)에 데이터를 쓸 때는 버퍼가 가득 차거나 flush() 혹은 close() 메소드가 호출될 때 한 번

  System.out.pring() 는 내부적으로 버퍼링을 사용하지 않음. 따라서 호출될 때마다 즉시 출력 장치에 데이터를 전달

#2) StringTokenizer
: 문자열을 구분자를 기준으로 나누는 데 사용되는 클래스
  split() 메소드와 달리 구분자를 여러 개 지정할 수 있으며, 구분자를 지정하지 않으면 공백이 기본 구분자가 됨

  split() 메소드는 내부적으로 정규 표현식을 사용하여 분리하기 때문에 더 많은 계산을 함.

TEST CASE:
1)
7
1 2 1 3 1 2 1
4
1 3
2 5
3 3
5 7

==>
1
0
1
1

 */