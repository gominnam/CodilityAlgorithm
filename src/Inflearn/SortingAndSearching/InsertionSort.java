package Inflearn.SortingAndSearching;

import java.util.Scanner;

public class InsertionSort {
    public int[] Solve(int[] numbers){
        for(int i=1; i<numbers.length; i++){
            int tmp = numbers[i], j;
            for(j=i-1; j>=0; j--){
                if(numbers[j] > tmp) numbers[j+1] = numbers[j];
                else break;
            }
            numbers[j+1] = tmp;
        }

        return numbers;
    }

    public static void main(String[] args){
        InsertionSort T = new InsertionSort();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for(int i=0; i<n; i++){
            numbers[i] = sc.nextInt();
        }

        for(int i : T.Solve(numbers)){
            System.out.print(i + " ");
        }
    }
}
/* 시간복잡도 : best : O(n) / avg, worst : O(n^2)
손안의 카드 정렬하는 방법과 유사
설명

N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.

정렬하는 방법은 선택정렬입니다.


입력
첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.

두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.


출력
오름차순으로 정렬된 수열을 출력합니다.

TEST CASE:
6
11 7 5 6 10 9

==> 5 6 7 9 10 11
 */

