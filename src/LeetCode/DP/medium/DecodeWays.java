package LeetCode.DP.medium;

public class DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));

            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        DecodeWays o = new DecodeWays();
        System.out.println(o.numDecodings("12"));//2
        System.out.println(o.numDecodings("226"));//3
        System.out.println(o.numDecodings("0"));//0
        System.out.println(o.numDecodings("06"));//0
        System.out.println(o.numDecodings("2101"));//1
        System.out.println(o.numDecodings("27"));//1
    }
}

/*

Thinking:
- String 에서 substring(a, b) 메서드 a는 포함, b는 미포함(b 전까지)이다.

-ref: https://leetcode.com/problems/decode-ways/

 */
