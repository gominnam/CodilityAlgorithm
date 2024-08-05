package Programmers.Level3;

import java.util.*;

public class AutoComplete {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int count = 0;
    }

    public int solution(String[] words) {
        TrieNode root = new TrieNode();
        int answer = 0;

        // Trie 구축
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
                node.count++;
            }
        }

        // 각 단어에 대해 최소 입력 횟수 계산
        for (String word : words) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                node = node.children.get(c);
                if (node.count == 1) {
                    answer += i + 1;
                    break;
                }
                if (i == word.length() - 1) {
                    answer += word.length();
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        AutoComplete autoComplete = new AutoComplete();
        String[] words = {"go", "gone", "guild"};
        System.out.println(autoComplete.solution(words));
    }
}

/*

Thinking:
1) Trie 자료구조
- 주로 문자열 검색을 효율적으로 수행하기 위해 사용된다.
  각 노드는 문자열의 문자를 나타내며, 문자열의 접두사를 기반으로 트리를 구축합니다.
- putIfAbsent() 메서드는 키가 존재하지 않을 때만 새로운 값을 추가

-ref: https://school.programmers.co.kr/learn/courses/30/lessons/17685

 */
