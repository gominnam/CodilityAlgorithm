package Inflearn.TwoPinterAndSlidingWindow;

import java.util.ArrayList;
import java.util.Scanner;

public class TwoPointers1 {
    public ArrayList<Integer> Solve(int n1, int[] arr1, int n2, int[] arr2){
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;

        while(p1<n1 && p2<n2){
            if(arr1[p1] < arr2[p2]){
                answer.add(arr1[p1++]);
            }
            else answer.add(arr2[p2++]);
        }
        while(p1<n1) answer.add(arr1[p1++]);
        while(p2<n2) answer.add(arr2[p2++]);

        return answer;
    }

    public static void main(String[] args){
        TwoPointers1 T = new TwoPointers1();

        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int arr1[] = new int[n1];
        for(int i=0; i<n1; i++){
            arr1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int arr2[] = new int[n2];
        for(int i=0; i<n2; i++){
            arr2[i] = sc.nextInt();
        }

        for(int i : T.Solve(n1, arr1, n2, arr2)){
            System.out.print(i + " ");
        }
    }
}


/*
합치고 정렬 하는 시간복잡도는 O(NlogN)이지만
투 포인터는 O(N)으로 더 시간효율성이 좋다.

TEST CASE:
3
1 3 5
5
2 3 6 7 9

=> 1 2 3 3 5 6 7 9
 */