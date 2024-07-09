package BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_1450 {
    public static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        int[] W = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            W[i] = Integer.parseInt(st.nextToken());
        }
        int half = N / 2;
        int[] dp1 = new int[1 << half];
        int[] dp2 = new int[1 << (N - half)];
        int cnt = 0;
        for (int i = 0; i < (1 << half); i++) {
            int sum = 0;
            for (int j = 0; j < half; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += W[j];
                }
            }
            if (sum <= C) {
                dp1[cnt++] = sum;
            }
        }
        cnt = 0;
        for (int i = 0; i < (1 << (N - half)); i++) {
            int sum = 0;
            for (int j = 0; j < (N - half); j++) {
                if ((i & (1 << j)) != 0) {
                    sum += W[half + j];
                }
            }
            if (sum <= C) {
                dp2[cnt++] = sum;
            }
        }
        int answer = 0;
        for (int i = 0; i < cnt; i++) {
            answer += upperBound(dp1, C - dp2[i]);
        }
        System.out.println(answer);
    }
}

/*
todo: repeat not understand
#, 냅색 알고리즘

- uppderBound: 이분탐색
- 비트연산자: 1 << 15 = 1*2^15

TESTCASE:
30 30
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1

==>
1073741824

 */
