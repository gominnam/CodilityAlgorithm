package BaekJoon.Search;

import java.io.*;
import java.util.*;

public class B_2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        TreeSet<Integer> tree = new TreeSet<>();
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(str[i]);
            tree.add(num);
            nums[i] = num;
        }
        int[] answer = new int[2];
        int result = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            Integer floor = tree.floor(-nums[i]);
            if(floor != nums[i] && floor != null) {
                int len = Math.abs(nums[i] - floor);
                if(result > len)
                    result = len;
                answer[0] = nums[i];
                answer[1] = floor;
            }
        }
        Arrays.sort(answer);
        sb.append(answer[0]).append(" ").append(answer[1]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

/*

 Structure TreeSet Methods
 1. higher (return higher value than input)
 2. lower (return lower value than input)
 3. ceiling (return higher or equal value than input)
 4. floor (return lower or equal value than input)

 */