package TimeComplexity;

public class FrogJmp {
    public int solution(int X, int Y, int D) {
        if(X == Y) return 0;
        int answer = (Y-X)/D;
        if((Y-X)%D != 0) answer++;

        return answer;
    }
}

/* 피드백
1. 시간복잡도를 고려하자

결론: 처음에 그냥 do~while 문으로 O(N)의 복잡도를 사용해서 틀렸다.
     더 효율적인 O(1)의 방법: 나눗셈을 사용하여 pass..
 */