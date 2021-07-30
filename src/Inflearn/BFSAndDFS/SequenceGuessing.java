package Inflearn.BFSAndDFS;

import java.util.Scanner;

public class SequenceGuessing {
    static int[] b, p, ch;
    static int n, f;
    boolean flag=false;
    static int[][] dy = new int[35][35];

    public int combi(int n, int r){
        if(dy[n][r] > 0) return dy[n][r];
        if(n==r || r ==0) return 1;
        else return dy[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }

    public void solution(int l, int sum){
        if(flag) return;
        if(l == n){
            if(sum==f){
                for(int x : p) System.out.print(x + " ");
                flag = true;
            }
        }else{
            for(int i=1; i<=n; i++){
                if(ch[i]==0){
                    ch[i]=1;
                    p[l] = i;
                    solution(l+1, sum+(p[l]*b[l]));
                    ch[i]=0;
                }
            }
        }
    }

    public static void main(String[] args){
        SequenceGuessing T = new SequenceGuessing();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();
        b = new int[n];
        p = new int[n];
        ch = new int[n+1];
        for(int i=0; i<n; i++){
            b[i] = T.combi(n-1, i);
        }
        T.solution(0, 0);
    }
}
/*

3C0 + 3C1 + 3C2 + 3C3

TEST CASE:
4 16

==> 3 1 2 4
 */