package TimeComplexity;

public class TapeEquilibrium {
    public int solution(int[] A) {
        int total = 0;
        for(int i : A){
            total += i;
        }

        int answer = 1000000000;
        int left = 0;
        for(int j=0; j<A.length-1; j++){
            left += A[j];
            total -= A[j];
            answer = Math.min(answer, Math.abs(left - total));
        }

        return answer;
    }
}

/* 피드백
1. slice 하는 수를 고려해야한다.
2. 시간복잡도 O(N)

결론: 역시나 영어지문 이해로 시간을 많이 썼다.
     틀린 부분은 A[0]와 A[1] 사이에서만 slice를 할 수 있기 때문에 마지막 index를 빼야 올바른 값을 구할 수 있다.
 */