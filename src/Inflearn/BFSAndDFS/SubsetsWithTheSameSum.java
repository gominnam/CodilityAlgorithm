package Inflearn.BFSAndDFS;

import java.util.*;

public class SubsetsWithTheSameSum {
    static String answer = "NO";
    static int total, n = 0;
    boolean flag = false;
    public void DFS(int L, int sum, int[] arr){
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
합이 같은 부분집합 (합이 같은 부분집합이 있으면 YES 같은게 없으면 NO)

6
1 3 5 6 7 10

==> YES

 */