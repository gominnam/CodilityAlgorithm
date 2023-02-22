package Inflearn.SortingAndSearching;

import java.util.Scanner;

public class BubbleSort {
    public int[] Solve(int[] numbers){
        for(int i=1; i<numbers.length; i++){
            for(int j=0; j<numbers.length-i; j++){
                if(numbers[j] > numbers[j+1]){
                    int swapValue = numbers[j+1];
                    numbers[j+1] = numbers[j];
                    numbers[j] = swapValue;
                }
            }
        }
        return numbers;
    }

    public static void main(String[] args){
        BubbleSort T = new BubbleSort();

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

/*
버블 정렬 : 시간복잡도 O(n^2)
거품이 쌓이면 맨위에 올라오듯 맨 끝 인덱스에 가장큰 값으로 정렬

설명

N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.

정렬하는 방법은 버블정렬입니다.


입력
첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.

두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.


출력
오름차순으로 정렬된 수열을 출력합니다.

TEST CASE:
6
13 5 11 7 23 15

==> 5 7 11 13 15 23
 */