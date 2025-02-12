package LeetCode.Array.medium;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

    public int numPairsDivisibleBy60(int[] time) {
        int[] remainders = new int[60];
        int count = 0;

        for (int t : time) {
            int remainder = t % 60;
            int complement = (60 - remainder) % 60;
            count += remainders[complement];
            remainders[remainder]++;
        }

        return count;
    }

    public static void main(String[] args) {
        PairsOfSongsWithTotalDurationsDivisibleBy60 a = new PairsOfSongsWithTotalDurationsDivisibleBy60();
        int[] time = {30, 20, 150, 100, 40};
        System.out.println(a.numPairsDivisibleBy60(time));//3
        time = new int[]{60, 60, 60};
        System.out.println(a.numPairsDivisibleBy60(time));//3
    }
}

/*

Thinking:
- 조건이 두 노래의 합 문제 잘 읽기.
- 나누는 수만큼 배열을 만들고 나머지를 저장하여 계산하는 방식.

-ref: https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

 */