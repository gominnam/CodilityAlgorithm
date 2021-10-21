package Basic;

public class MaximumSubsequenceSum {
    static int MIN = Integer.MIN_VALUE;
    public static void main(String[] args){
        int[] arr = {-7, 4, -3, 6, 3, -8, 3, 4};
        int ret = fastestMaxSum(arr);
        System.out.println(ret);
    }

    public static int fastestMaxSum(int[] arr){
        int N = arr.length, ret = MIN, psum = 0;
        for(int i=0; i<N; ++i){
            psum = Math.max(psum, 0) + arr[i];//이쪽 소스가 핵심
            ret = Math.max(psum, ret);
        }
        return ret;
    }
}
/*
    ## 동적계획법 (시간복잡도 : O(N) // 선형)

    1. psum은 음수가될 경우 0으로 초기화
    2. 다음 arr[i]를 psum과 더함
    3. 최대 합 변수와 psum을 비교후 갱신

    위 로직 반복

*/