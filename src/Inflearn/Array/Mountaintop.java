package Inflearn.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mountaintop {
    public int countPeak(int[][] arr){
        int peaks = 0;
        int[] moveX = {-1, 1, 0, 0};
        int[] moveY = {0, 0, -1, 1};
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                boolean isPeak = true;
                for(int k=0; k<4; k++){
                    int nextX = i + moveX[k];
                    int nextY = j + moveY[k];
                    if(nextX >= 0 && nextX < arr.length && nextY >= 0 && nextY < arr.length){
                        if(arr[nextX][nextY] >= arr[i][j]){
                            isPeak = false;
                            break;
                        }
                    }
                }
                if(isPeak) peaks++;
            }
        }
        return peaks;
    }

    public static void main(String[] args) throws IOException {
        Mountaintop T = new Mountaintop();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        System.out.println(T.countPeak(arr));
    }
}
/*
지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.

각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.

격자의 가장자리는 0으로 초기화 되었다고 가정한다.

만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.

Image1.jpg


입력
첫 줄에 자연수 N이 주어진다.(2<=N<=50)

두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.


출력
봉우리의 개수를 출력하세요.

TEST CASE:
5
5 3 7 2 3
3 7 1 6 1
7 2 5 3 4
4 3 6 4 1
8 7 3 5 2

==>
10
 */
