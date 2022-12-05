package Inflearn.TwoPinterAndSlidingWindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MergeTwoArrays {

    public ArrayList<Integer> solution(int[] n1, int[] n2){
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<n1.length; i++){
            arr.add(n1[i]);
        }
        for(int j=0; j<n2.length; j++){
            arr.add(n2[j]);
        }
        Collections.sort(arr);
        return arr;
    }

    public static void main(String[] args){
        MergeTwoArrays mta = new MergeTwoArrays();
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] array1 = new int[n1];
        for(int i=0; i<array1.length; i++){
            array1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] array2 = new int[n2];
        for(int i=0; i<array2.length; i++){
            array2[i] = sc.nextInt();
        }

        for(int i : mta.solution(array1, array2)){
            System.out.print(i + " ");
        }
    }
}
/*
두 배열 합치기
설명

오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.


입력
첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.

두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.

세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.

네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.

각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.


출력
오름차순으로 정렬된 배열을 출력합니다.

TEST CASE:
3
1 3 5
5
2 3 6 7 9

==>
1 2 3 3 5 6 7 9
 */