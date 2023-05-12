package Programmers.Level3;

public class BestSet {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int div = s/n;
        int remain = s%n;

        if(div < 1) return new int[] {-1};

        for(int i=n-1; i>=0; i--){
            if(remain > 0){
                answer[i] = div+1;
                remain--;
            }
            else answer[i] = div;
        }

        return answer;
    }

    public static void main(String[] args){
        BestSet bs = new BestSet();
        int n = 2;
        int s = 9;
        for(int i : bs.solution(n, s)){
            System.out.print(i + " ");
        }
    }
}
