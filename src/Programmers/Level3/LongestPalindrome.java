package Programmers.Level3;

public class LongestPalindrome {
    public int manacher(String str){
        int maxLength = 0;
        int p = 0, r = 0;
        int l = str.length();
        int[] A = new int[l];
        for(int i=0; i<str.length(); i++){
            if(i <= r){
                A[i] = Math.min(A[2*p-i], r-i);
            }

            while(i-A[i]-1 >= 0 && i+A[i]+1 < l && str.charAt(i-A[i]-1) == str.charAt(i+A[i]+1)){
                A[i]++;
            }

            if(r < (i+A[i])){
                r = i+A[i];
                p = i;
            }
            maxLength = Math.max(maxLength, A[i]);
        }
        return maxLength;
    }

    public String setOddString(String str, String seperator){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            sb.append(seperator);
            sb.append(str.charAt(i));
        }
        sb.append(seperator);
        return sb.toString();
    }

    public int solution(String s){
        s = setOddString(s, "#");
        return manacher(s);
    }

    public static void main(String[] args){
        LongestPalindrome lp = new LongestPalindrome();
        String s = "abcdcba";
        System.out.println(lp.solution(s));
    }
}
