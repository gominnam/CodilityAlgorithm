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
/*
학급 회장(해쉬)
설명

학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.

투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.

선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.

반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.


입력
첫 줄에는 반 학생수 N(5<=N<=50)이 주어집니다.

두 번째 줄에 N개의 투표용지에 쓰여져 있던 각 후보의 기호가 선생님이 발표한 순서대로 문자열로 입력됩니다.


출력
학급 회장으로 선택된 기호를 출력합니다.


TEST CASE:
15
BACBACCACCBDEDE

==>
C
 */