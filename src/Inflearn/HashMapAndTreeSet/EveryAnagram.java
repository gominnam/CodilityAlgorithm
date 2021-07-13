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
