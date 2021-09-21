package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class D_6549 {
    static int[] histogram;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N;
        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            histogram = new int[N];
            if(N == 0) break;
            for(int i=0; i<N; i++){
                histogram[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(getArea(0, N-1)).append('\n');
            histogram = null;
        }
        System.out.println(sb);
    }
    public static long getArea(int left, int right){
        if(left == right) return histogram[left];

        int mid = (left + right) / 2;
        long ret = Math.max(getArea(left, mid), getArea(mid+1, right));//두 구간으로 나누어 더 넓은 너비를 반환

        int start = mid;
        int end = mid + 1;
        long height = Math.min(histogram[start], histogram[end]);
        ret = (long)Math.max(ret, height*2);

        while(left < start || end < right){
            if(left < start && end < right){
                if(histogram[start-1] < histogram[end+1])
                    height = (long)Math.min(height, histogram[++end]);
                else
                    height = (long)Math.min(height, histogram[--start]);
            }
            else if(left < start){
                height = (long)Math.min(height, histogram[--start]);
            }
            else if(end < right){
                height = (long)Math.min(height, histogram[++end]);
            }
            ret = Math.max(ret, height * (end-start+1));
        }
        return ret;
    }

}
/*
현재 풀이방식 : 분할정복 O(NlogN)
히스토그램(가장 넓은 직사각형 넓이 구하기)
 */