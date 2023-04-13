package BaekJoon.String;

import java.io.*;

public class LongestPalindromeSubstring {
    public int getLongestLengthPalindrome(String str){
        int length = 0;
        int N = str.length();
        int[] A = new int[str.length()];
        int r = 0, p = 0;
        for (int i = 0; i < N; i++) {
            if (i <= r)
                A[i] = Math.min(A[2*p-i], r-i);
            else
                A[i] = 0;

            //양 끝의 인덱스가 배열 길이를 벗어나지 않고 && 문자가 같다면 펠린드롬에 추가후 길이 늘려주기
            while (i-A[i]-1 >= 0 && i+A[i]+1 < N && str.charAt(i-A[i]-1) == str.charAt(i+A[i]+1))
                A[i]++;

            //펠린드론 중심축 변경
            if (r < i+A[i]) {
                r = i+A[i];
                p = i;
            }
            length = Math.max(length, A[i]);
        }
        return length;
    }

    public String setOddString(String str, String seperator){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            sb.append(seperator);
            sb.append(str.charAt(i));
        }
        sb.append(seperator);
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        str = lps.setOddString(str, "#");
        String answer = lps.getLongestLengthPalindrome(str)+"";
        bw.write(answer);
        bw.flush();
    }
}
/*
144444번 문제
문제
알파벳 소문자로만 이루어진 문자열 S가 주어졌을 때, S의 부분 문자열 중에서 팰린드롬 이면서 길이가 가장 긴 것의 길이를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 알파벳 소문자로만 이루어진 문자열 S가 주어진다. S의 길이는 100,000을 넘지 않는다.

출력
첫째 줄에 S의 부분 문자열 중에서 팰린드롬 이면서 길이가 가장 긴 것의 길이를 출력한다.

TEST CASE:
baekjoon
=> 2

eevee
=> 5

abaxabaxabybaxabyb
=> 11

bananac
=> 5

feedback:
manacher algorithm을 사용해야 시간복잡도[O(N)]를 통과할 수 있다.

manacher 알고리즘이란?
문자열 S에 대한 배열을 구할 수 있다.

ex)
b a n a n a c
0 0 1 2 1 0 0    <- 숫자 의 값은 펠린드롬의 반지름의 길이

동작원리

1. i는 1부터 N(문자열의 길이)까지 진행된다.

2. j < i인 모든 j에 대해 r=max(j + A[j])이라 하고, 또한 그러한 j를 p라 하자. 즉, r = p + A[p]

3. i와 r의 대소 관계에 따라 A[i]의 초기값이 결정된다.

  1. i > r이라면, A[i]의 초기값은 0이다.

  2. i ≤ r이라면, i는 p를 중심으로 한 회문에 속한다. 따라서 그 회문에서 i의 대칭점을 i′라 하자. 즉, i′=2p - i가 된다.

     그리고 A[i]의 초기값은 min(r - i, A[i′])이다. (즉, r은 중심점 p를 기준으로 하는 p + A[p]를 의미하게 된다.)

4. A[i]의 초기값이 결정되고, S[i - A[i]]와 S[i + A[i]]가 같을 때까지 A[i]를 증가시킨다.

//r은 가장 긴 펠린드롬의 우측 끝, p는 가장 긴 펠린드롬의 중심축


ref1 - https://www.crocus.co.kr/1075
ref2 - https://www.geeksforgeeks.org/manachers-algorithm-linear-time-longest-palindromic-substring-part-1/
ref3 - https://www.geeksforgeeks.org/manachers-algorithm-linear-time-longest-palindromic-substring-part-2/
ref4 - https://www.geeksforgeeks.org/manachers-algorithm-linear-time-longest-palindromic-substring-part-3-2/
ref5 - https://www.geeksforgeeks.org/manachers-algorithm-linear-time-longest-palindromic-substring-part-4/?ref=lbp
 */