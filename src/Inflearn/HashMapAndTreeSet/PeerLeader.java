package Inflearn.HashMapAndTreeSet;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class PeerLeader {
    public char solution(int n, String s){
        char answer = 'A';
        int max = 0;
        char[] arrChar = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : arrChar){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        Iterator<Character> keys = map.keySet().iterator();
        while(keys.hasNext()){
            Character c = keys.next();
            int cnt = map.get(c);
            if(cnt > max){
                answer = c.charValue();
                max = cnt;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        PeerLeader T = new PeerLeader();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.next();
        String s = sc.nextLine();

        System.out.println(T.solution(n, s));
    }
}
