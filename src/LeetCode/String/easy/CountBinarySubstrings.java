package LeetCode.String.easy;

public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        int prev = 0, curr = 1, count = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            } else {
                count += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
        }

        return count + Math.min(prev, curr);
    }

    public static void main(String[] args) {
        CountBinarySubstrings cbs = new CountBinarySubstrings();
        String s = "00110011";
        System.out.println(cbs.countBinarySubstrings(s)); // 6
    }
}

/*

Thinking:
- group counting algorithm
- prev: 이전 연속된 문자열의 개수
- curr: 현재 연속된 문자열의 개수
- count: 결과값

-ref: https://leetcode.com/problems/count-binary-substrings/description/
-ref: gpt answer

 */