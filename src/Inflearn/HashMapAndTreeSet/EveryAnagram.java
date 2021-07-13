package Inflearn.HashMapAndTreeSet;

import java.util.*;

public class EveryAnagram {
    public int Solve(String s1, String s2){
        int answer = 0;
        HashMap<Character, Integer> s = new HashMap<>();
        HashMap<Character, Integer> t = new HashMap<>();
        for(char x : s2.toCharArray()){
            t.put(x, t.getOrDefault(x, 0)+1);
        }
        int p = 0;
        for(int i=0; i<s1.length(); i++){
            s.put(s1.charAt(i), s.getOrDefault(s1.charAt(i), 0)+1);
            if(i >= s2.length()-1){
                if(s.equals(t)) answer++;
                s.put(s1.charAt(p), s.get(s1.charAt(p))-1);
                if(s.get(s1.charAt(p))==0) s.remove(s1.charAt(p));
                p++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        EveryAnagram T = new EveryAnagram();

        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.next();

        System.out.println(T.Solve(s1, s2));
    }
}

/*
설명

S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.

아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.


입력
첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.

S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.


출력
S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.


TEST CASE:
bacaAacba
abc

==> 3
 */