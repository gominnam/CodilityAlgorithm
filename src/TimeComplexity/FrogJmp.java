package TimeComplexity;

public class FrogJmp {
    public int solution(int X, int Y, int D) {
        if(X == Y) return 0;
        int answer = (Y-X)/D;
        if((Y-X)%D != 0) answer++;

        return answer;
    }
}
