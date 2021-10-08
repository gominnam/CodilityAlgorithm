package Programmers.Level2;

public class BinaryRecursive {
    public static void main(String[] args){
        String s = "10101011101";
        int[] tmp = solution(s);

        int a = 0;

    }

    public static int[] solution(String s){
        int[] answer = new int[2];
        while(true){
            if(s.length() == 1) break;

            answer[1] += check(s);
            s = s.replaceAll("0", "");
            s = toBinary(s.length());

            answer[0]++;
        }

        return answer;
    }

    public static int check(String str){
        int cnt = 0;
        for(char c : str.toCharArray()){
            if(c == '0') cnt++;
        }

        return cnt;
    }

    public static String toBinary(int n){
        return Integer.toBinaryString(n);
    }
}
