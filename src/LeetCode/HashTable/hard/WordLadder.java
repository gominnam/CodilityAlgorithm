package LeetCode.HashTable.hard;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                char[] wordChars = queue.poll().toCharArray();
                for(int j = 0; j < wordChars.length; j++){
                    char originalChar = wordChars[j];
                    for(char c = 'a'; c <= 'z'; c++){
                        wordChars[j] = c;
                        String newWord = new String(wordChars);
                        if(newWord.equals(endWord)){
                            return level + 1;
                        }
                        if(wordSet.contains(newWord)){
                            queue.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    wordChars[j] = originalChar;
                }
            }
            level++;
        }

        return 0;
    }

    public static void main(String[] args) {
        WordLadder w = new WordLadder();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(w.ladderLength(beginWord, endWord, wordList));
    }
}

/*

Thinking:
- BFS와 Set 자료구조를 이용한 풀이
- beginWord에서 시작하여 각 배열의 index 별로 문자열을 하나씩 바꿔가며 endWord와 같은지 확인

-ref: https://leetcode.com/problems/word-ladder/

 */