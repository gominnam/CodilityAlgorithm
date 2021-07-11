package Inflearn.TwoPinterAndSlidingWindow;

import java.util.*;

public class TwoPointers2 {
    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b){
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        while(p1<n && p2<m){
            if(a[p1] < b[p2]) p1++;
            else if(a[p1] == b[p2]){
                answer.add(a[p1++]);
                p2++;
            }
            else p2++;
        }

        return answer;
    }

    public static void main(String[] args){
        TwoPointers2 T = new TwoPointers2();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int b[] = new int[m];
        for(int i=0; i<m; i++){
            b[i] = sc.nextInt();
        }

        for(int i : T.solution(n, m, a, b)){
            System.out.print(i + " ");
        }
    }
}

/*

첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.

두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.

세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.

네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.

각 집합의 원소는 1,000,000,000이하의 자연수입니다.

TEST CASE:
5
1 3 9 5 2
5
3 2 5 7 8

==> 2 3 5

 */
