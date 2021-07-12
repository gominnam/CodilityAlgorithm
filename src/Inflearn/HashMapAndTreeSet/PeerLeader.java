package Inflearn.HashMapAndTreeSet;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class PeerLeader {
    public char solution(int n, String s){
        char answer = ' ';
        int max = 0;
        char[] arrChar = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : arrChar){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        //map.containsKey('A'); A라는 key를 포함하는지 알려주는 매서드 [True, False]
        //map.size(); key의 갯수를 알려준다. [Number]
        //map.remove('A') 특정키를 삭제하는 매서드   [A의 Value 반환]

        Iterator<Character> keys = map.keySet().iterator();
        while(keys.hasNext()){
            Character c = keys.next();
            if(map.get(c) > max) {
                answer = c;
                max = map.get(c);
            }
        }

        return answer;
    }

    public static void main(String[] args){
        PeerLeader T = new PeerLeader();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();

        System.out.println(T.solution(n, s));
    }
}
