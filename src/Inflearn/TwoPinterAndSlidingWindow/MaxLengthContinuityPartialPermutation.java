package Inflearn.TwoPinterAndSlidingWindow;

import java.util.Scanner;

public class MaxLengthContinuityPartialPermutation {//todo: repeat
    public int solution(int n, int m, int[] a){
        int answer = 0;
        int cnt = 0, p = 0;
        for(int i=0; i<n; i++){
            if(a[i] == 0 && cnt < m) cnt++;
            else if(a[i] == 0 && cnt == m) {
                answer = Math.max(answer, i-p);
                while(a[p] != 0){
                    p++;
                }
                p++;
            }

            if(i == n-1) answer = Math.max(answer, i-p);
        }

        return answer;
    }

    /* 다른 풀이 방법 */
    public int solutionA(int n, int k, int[]arr){
        int answer=0, cnt=0, lt=0;
        for(int rt=0; rt<n; rt++){
            if(arr[rt] == 0) cnt++;
            while(cnt>k){
                if(arr[lt]==0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt-lt+1);
        }
        return answer;
    }

    public static void main(String[] args){
        MaxLengthContinuityPartialPermutation T = new MaxLengthContinuityPartialPermutation();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, m, a));
    }
}

/*
0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.

만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면

1 1 0 0 1 1 0 1 1 0 1 1 0 1
            1     1
여러분이 만들 수 있는 1이 연속된 연속부분수열은

위의 1을 2개 넣은 모습이며 그 길이는 8입니다.


입력
첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.

두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.


출력
첫 줄에 최대 길이를 출력하세요.


TEST CASE:
14 2
1 1 0 0 1 1 0 1 1 0 1 1 0 1

==> 8
 */