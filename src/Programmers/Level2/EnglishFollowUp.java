package Programmers.Level2;

import java.util.HashSet;
import java.util.Set;

public class EnglishFollowUp {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        Set<String> set = new HashSet<>();
        StringBuilder priorStr = new StringBuilder(words[0]);
        set.add(words[0]);
        for(int i=1; i<words.length; i++){
            String curStr = words[i].charAt(0)+"";
            if(!priorStr.substring(priorStr.length()-1).equals(curStr) || set.contains(words[i])){
                answer[0] = (i%n)+1;
                answer[1] = (i/n)+1;
                break;
            }
            priorStr.append(words[i]);
            set.add(words[i]);
        }
        return answer;
    }

    public static void main(String[] args){
        EnglishFollowUp ef = new EnglishFollowUp();
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        for(int i : ef.solution(3, words)){
            System.out.print(i + " ");
        }
    }
}
