package Inflearn.HashMapAndTreeSet;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {
    public String Solve(String s1, String s2){
        HashMap<Character, Integer> m1 = new HashMap<>();
        HashMap<Character, Integer> m2 = new HashMap<>();

        for(int i=0; i<s1.length(); i++){
            m1.put(s1.charAt(i), m1.getOrDefault(s1.charAt(i), 0) + 1);
            m2.put(s2.charAt(i), m2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        for(char key : m1.keySet()){
            if(m1.get(key) != m2.get(key)) return "NO";
        }

        return "YES";
    }

    public static void main(String[] args){
        Anagram T = new Anagram();

        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        System.out.println(T.Solve(str1, str2));
    }
}

/*
Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.

예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로

알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.

길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요. 아나그램 판별시 대소문자가 구분됩니다.

TEST CASE:
AbaAeCe
baeeACA

==> YES

abaCC
Caaab

==> NO
 */