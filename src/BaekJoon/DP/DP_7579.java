package BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_7579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] dp = new int[10001];
        String[] memoryInput = br.readLine().split(" ");
        String[] costInput = br.readLine().split(" ");
        int[] memory = new int[N+1];
        int[] cost = new int[N+1];
        int totalCost = 0;
        for(int i=1; i<=N; i++){
            memory[i] = Integer.parseInt(memoryInput[i-1]);
            cost[i] = Integer.parseInt(costInput[i-1]);
            totalCost += cost[i];
        }

        for (int i = 1; i <= N; i++) {
            for (int j = totalCost; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
            }
        }

        int answer = 0;
        for (int i = 0; i <= totalCost; i++) {
            if (dp[i] >= M) {
                answer = i;
                break;
            }
        }

        System.out.print(answer);
    }
}

/*

thinking:
Knapsack Algorithm

TEST CASE:
1)


2)
7 120
20 91 92 93 94 95 100
1 2 2 2 2 2 2

==> 3


19 20169
240 2560 434 6 31 577 500 2715 2916 952 2490 258 1983 1576 3460 933 1660 2804 2584
82 77 81 0 36 6 53 78 49 82 82 33 66 8 60 0 98 91 93
==> 484

 */