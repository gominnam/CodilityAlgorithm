package Programmers.Level2;

public class CalculateDecimalNumberK {
    public String changeK(int n, int k){
        StringBuilder sb = new StringBuilder();
        while(n>=k){
            int remain = n%k;
            sb.insert(0, remain);
            n /= k;
        }
        return sb.insert(0, n).toString();
    }

    public boolean isPrime(long n){
        if(n==1) return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }

    public int solution(int n, int k) {
        int answer = 0;
        String changedK = changeK(n, k);
        String[] numbers = changedK.split("0");
        for(String s : numbers){
            if(s.equals("")) continue;
            if(isPrime(Long.parseLong(s))) answer++;
        }
        return answer;
    }

    public static void main(String[] args){
        CalculateDecimalNumberK cdnk = new CalculateDecimalNumberK();
        int n = 437674;
        int k = 3;
        System.out.print(cdnk.solution(n, k));
    }
}
/*
feedback:

진수변환 함수 Integer에 있음
String temp[] = Integer.toString(n, k).split("0");

위의 소스를 이용한 경우
changeK 함수를 만들지 않고 소스가 간결해진다.

 */