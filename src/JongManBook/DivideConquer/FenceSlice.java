package JongManBook.DivideConquer;

import java.io.*;
import java.util.StringTokenizer;

public class FenceSlice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int fenceSize = Integer.parseInt(br.readLine());
            int[] fenceInfo = new int[fenceSize];
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<fenceSize; j++){
                fenceInfo[j] = Integer.parseInt(st.nextToken());
            }
            bw.write(solve(fenceInfo, 0, fenceSize-1) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve(int[] fences, int left, int right){
        if(left == right) return fences[0];
        int mid = (left + right) / 2;
        //분할하여 넓이 구하기
        int ret = Math.max(solve(fences, left, mid), solve(fences, mid+1, right));
        //양쪽 모두 걸치는 사각형 넓이 구하기
        int lo = mid, hi = mid+1;
        int height = Math.min(fences[lo], fences[hi]);
        ret = Math.max(ret, height*2);
        while(left < lo || hi < right){
            //항상 높이가 높은 쪽으로 확장
            if(hi < right && (lo == left || fences[lo-1] < fences[hi+1])){
                ++hi;
                height = Math.min(height, fences[hi]);
            }
            else{
                --lo;
                height = Math.min(height, fences[lo]);
            }
            //확장한 후 사각형의 넓이
            ret = Math.max(ret, height * (hi - lo + 1));
        }

        return ret;
    }
}
/*
TEST CASE:
3
7
7 1 5 9 6 7 3
7
1 4 4 4 4 1 1
4
1 8 2 2

==>
20
16
8
 */