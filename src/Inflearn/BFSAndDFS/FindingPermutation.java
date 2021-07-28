package Inflearn.BFSAndDFS;

import java.util.*;

public class FindingPermutation {
    static int n, m;
    static boolean[] chk;
    static int[] arr;

    public void solution(int L, int[] p){
        if(L==m){
            for(int x : p) System.out.print(x + " ");
            System.out.println();
        }
        else{
            for(int i=0; i<n; i++){
                if(!chk[i]) {
                    chk[i] = true;
                    p[L] = arr[i];
                    solution(L+1, p);
                    chk[i] = false;
                }
            }
        }
    }

    public static void main(String[] args){
        FindingPermutation T = new FindingPermutation();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        chk = new boolean[n];
        int[] p = new int[m];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);

        T.solution(0, p);
    }
}
/* BFS
feedback -  1. p[]도 static으로 하면 편리하다.
            2. forEach문 활용하기

TEST CASE:
3 2
3 6 9

==>
3 6
3 9
6 3
6 9
9 3
9 6
 */