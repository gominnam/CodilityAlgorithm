package BaekJoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S_14719 {

    public static int getAnswer(int[] arr, int W){
        int answer = 0;
        for(int i=1; i<W-1; i++) {
            int leftMax = 0;
            int rightMax = 0;

            for(int j=0; j<i; j++) {
                leftMax = Math.max(leftMax, arr[j]);
            }

            for(int j=i+1; j<W; j++) {
                rightMax = Math.max(rightMax, arr[j]);
            }

            int min = Math.min(leftMax, rightMax);

            if(arr[i] < min) {
                answer += min - arr[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int H = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);
        int[] arr = new int[W];
        input = br.readLine().split(" ");
        for(int i=0; i<input.length; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        System.out.println(getAnswer(arr, W));
    }
}

/*

# Step
1. for 문 index i 값을 1 부터 W-1까지 순환하면서 leftMax 와 rightMax 값을 구한다.// index i를 기준으로 왼쪽 오른쪽 Max값을 구하는 것이다.
2. leftMax와 rightMax 값준 Minimum 값을 구한다.
3. arr[i] 값과 min 값을 비교하고 min 값이 더 크다면 answer 에 min - arr[i] 값을 더해준다.



시뮬레이션 문제는 주어진 규칙이나 조건에 따라 문제 상황을 단계별로 직접 시뮬레이션해 나가면서 해결하는 유형의 문제입니다.

이러한 문제를 해결하기 위해서는 문제에서 요구하는 과정을 정확히 이해하고, 이를 코드로 구현하는 능력이 필요합니다.

 */