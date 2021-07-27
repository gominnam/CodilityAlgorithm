package Inflearn.BFSAndDFS;

import java.util.*;

public class PermutationOfRepetition {
    static int[] pm;
    static int n, m;

    public void solution(int L){
        if(L==m){
            for(int x : pm) System.out.print(x + " ");
            System.out.println();
        }
        else{
            for(int i=1; i<=n; i++){
                pm[L] = i;
                solution(L+1);
            }
        }
    }

    public static void main(String[] args){
        PermutationOfRepetition T = new PermutationOfRepetition();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];
        T.solution(0);
    }
}

/*
중복순열 구하기

1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열하는 방법을 모두 출력합니다.

첫 번째 줄에 결과를 출력합니다.
출력순서는 사전순으로 오름차순으로 출력합니다.

TEST CASE:
3 2

==>
1 1
1 2
1 3
2 1
2 2
2 3
3 1
3 2
3 3
 */