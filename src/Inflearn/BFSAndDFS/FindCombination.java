package Inflearn.BFSAndDFS;

import java.util.Scanner;

public class FindCombination {
    static int[] combi;
    static int n, m;

    public void DFS(int L, int s){// L: 레벨, S: 스타트 번호
        if(L==m){
            for(int x : combi) System.out.print(x + " ");
            System.out.println();
        }
        else{
            for(int i=s; i<=n; i++){ //오름차순만
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }
    }

    public static void main(String[] args){
        FindCombination T = new FindCombination();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        combi = new int[m];
        T.DFS(0, 1);
    }
}
/*
조합 구하기

TEST CASE:
4 2

==>
1 2
1 3
1 4
2 3
2 4
3 4

 */