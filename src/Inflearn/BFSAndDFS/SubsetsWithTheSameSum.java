package Inflearn.BFSAndDFS;

import java.util.*;

public class SubsetsWithTheSameSum {
    static String answer = "NO";
    static int total, n = 0;
    boolean flag = false;
    public void DFS(int L, int sum, int[] arr){//L:arr Index, sum:총합, arr배열
        if(flag) return;
        if(sum>total/2) return;
        if(L == n){
            if((total-sum)==sum) {
                answer = "YES";
                flag = true;
            }
        }
        else{
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }

    public static void main(String[] args){
        SubsetsWithTheSameSum T = new SubsetsWithTheSameSum();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        //total = Arrays.stream(arr).sum(); //stream 사용하는 방법
        T.DFS(0, 0, arr);
        System.out.println(answer);
    }

}
/*
설명

철수는 그의 바둑이들을 데리고 시장에 가려고 한다. 그런데 그의 트럭은 C킬로그램 넘게 태울수가 없다.

철수는 C를 넘지 않으면서 그의 바둑이들을 가장 무겁게 태우고 싶다.

N마리의 바둑이와 각 바둑이의 무게 W가 주어지면, 철수가 트럭에 태울 수 있는 가장 무거운 무게를 구하는 프로그램을 작성하세요.


입력
첫 번째 줄에 자연수 C(1<=C<=100,000,000)와 N(1<=N<=30)이 주어집니다.

둘째 줄부터 N마리 바둑이의 무게가 주어진다.


출력
첫 번째 줄에 가장 무거운 무게를 출력한다.

TEST CASE:
6
1 3 5 6 7 10

==> YES

 */