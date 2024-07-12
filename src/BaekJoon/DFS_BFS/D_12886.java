package BaekJoon.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class D_12886 {
    static Set<String> set = new HashSet<>();
    static boolean flag = false;

    static boolean isSame(int[] nums){
        return nums[0] == nums[1] && nums[1] == nums[2];
    }


    public static int[] swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b]-nums[a];
        nums[b] = temp*2;
        return nums;
    }

    public static void recursive(int[] nums){
        int allSet = 1 << 3;
        Arrays.sort(nums);
        if(isSame(nums)) {
            flag = true;
            return;
        }

        for(int i=0; i<allSet; i++){
            // 2개의 원소만 선택하였을 경우 (ex) 011, 101, 110
            if(Integer.bitCount(i) == 2){
                // 2진수로 선택한 배열 표현
                StringBuilder sb = new StringBuilder(Integer.toBinaryString(i)).append(" ");
                int[] arr = new int[2];
                int idx = 0;
                for(int j=0; j<3; j++){
                    sb.append(nums[j]).append(",");
                    // i의 j번째 비트가 1인지 확인
                    if((i & (1 << j)) > 0){
                        arr[idx++] = j;
                    }
                }
                if(set.contains(sb.toString())) continue;
                set.add(sb.toString());
                int[] swappedArray = swap(nums.clone(), arr[0], arr[1]);
                recursive(swappedArray.clone());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int[] nums = new int[3];
        for(int i=0; i<3; i++){
            nums[i] = Integer.parseInt(input[i]);
        }
        recursive(nums);
        if(flag) bw.write("1");
        else bw.write("0");
        bw.flush();
        bw.close();
        br.close();
    }
}
/*

Thinking:

해결하긴 하였지만, 다른 해결된 소스는 BFS가 속도, 메모리 상에서 훨씬 효율적인 결과가 있었다.(B_12886.java 소스 참고)
bitmask 메서드 배운것:
Integer.bitCount(i) : i의 1의 개수를 반환
Integer.toBinaryString(i) : i를 2진수로 변환


TEST CASE:
1)
3 7 14

==> 1

2)
1 1 2

==> 0

 */


