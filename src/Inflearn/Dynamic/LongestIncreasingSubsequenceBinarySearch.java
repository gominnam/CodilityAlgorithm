package Inflearn.Dynamic;

import java.util.Scanner;

public class LongestIncreasingSubsequenceBinarySearch {
    static int[] dp;

    public int binarySearch(int left, int right, int key){
        int mid;
        while(left < right){
            mid = (left+right)/2;
            if(dp[mid] < key){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args){
        LongestIncreasingSubsequenceBinarySearch T = new LongestIncreasingSubsequenceBinarySearch();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        dp = new int[N+1];
        int len = 0;
        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
            if(nums[i] > dp[len]){
                len++;
                dp[len] = nums[i];
            }
            else{
                int index = T.binarySearch(0, len, nums[i]);
                dp[index] = nums[i];
            }
        }
        System.out.print(len);
    }
}
/*
feedback - LIS(LongestIncreasingSubsequence)
BinarySearch 방식으로 시간복잡도: O(NlogN)
==> 더 좋은 대안인 이분탐색 방법

설명

N개의 자연수로 이루어진 수열이 주어졌을 때, 그 중에서 가장 길게 증가하는(작은 수에서 큰 수로) 원소들의 집합을 찾는 프로그램을 작성하라.

예를 들어, 원소가 2, 7, 5, 8, 6, 4, 7, 12, 3 이면 가장 길게 증가하도록 원소들을 차례대로 뽑아내면 2, 5, 6, 7, 12를 뽑아내어

길이가 5인 최대 부분 증가수열을 만들 수 있다.


입력
첫째 줄은 입력되는 데이터의 수 N(3≤N≤1,000, 자연수)를 의미하고,

둘째 줄은 N개의 입력데이터들이 주어진다.


출력
첫 번째 줄에 부분증가수열의 최대 길이를 출력한다.

TEST CASE:
8
5 3 7 8 6 2 9 4

==> 4
 */