package Codility.Arrays;

public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        if(A.length == 0) return A;
        int rtCnt = K % A.length;

        int[] ans = new int[A.length];
        for(int i=0; i<A.length; i++){
            ans[(i+rtCnt) % A.length] = A[i];
        }

        return ans;
    }
}

/* 피드백
1. rotation 하는 수만큼 ans[i+rotationCnt]를 이동시키고 A[i]값을 넣는다.
2. i+rotationCnt가 int[]의 index를 넘어갈 수 있으므로 배열 크기만큼 나머지 연산을 추가한다.
3. A가 빈 Array일 경우를 고려해야 한다. length == 0일 경우 return 조건문 넣기

결론: 3번째 피드백에서 막혀서 기본문제이지만 시간을 오래 잡아 먹었다.
        int rtCnt = K % A.length;
        if(rtCnt == 0) return A;
     이렇게 작성하다보니 A.length 값이 0일 경우에 % 연산자 error가 발생했음.
 */