package Inflearn.Dynamic;

import java.util.Scanner;

public class StoneBridge {
    static int[] stones;

    public int solution(int n){
        stones[1] = 1;
        stones[2] = 2;
        for(int i=3; i<=n; i++){
            stones[i] = stones[i-1] + stones[i-2];
        }
        return stones[n] + stones[n-1];
    }

    public static void main(String[] args){
        StoneBridge T = new StoneBridge();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        stones = new int[n+1];
        System.out.println(T.solution(n));
    }
}
/*
설명

철수는 학교에 가는데 개울을 만났습니다. 개울은 N개의 돌로 다리를 만들어 놓았습니다.

철수는 돌 다리를 건널 때 한 번에 한 칸 또는 두 칸씩 건너뛰면서 돌다리를 건널 수 있습니다.

철수가 개울을 건너는 방법은 몇 가지일까요?

Image1.jpg


입력
첫째 줄은 돌의 개수인 자연수 N(3≤N≤35)이 주어집니다.


출력
첫 번째 줄에 개울을 건너는 방법의 수를 출력합니다.

TEST CASE:
7

==> 34
 */