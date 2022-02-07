package Programmers.Level1;

import java.util.*;

public class GetRepertUser {
    public static int[] solution(String[] id_list, String[] report, int k){
        int[] answer = new int[id_list.length];
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0; i<id_list.length; i++){
            map.put(id_list[i], new ArrayList<>());
        }

        for(int i=0; i<report.length; i++){
            String[] users = report[i].split(" ");
            if(!map.get(users[1]).contains(users[0])){
                map.get(users[1]).add(users[0]);
            }
        }

        for(int i=0; i<answer.length; i++){
            for(String key : map.keySet()){
                if(map.get(key).contains(id_list[i]) && map.get(key).size() >= k){
                    answer[i]++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        int[] answer = solution(id_list, report, k);
        for(int i=0; i<answer.length; i++){
            System.out.println(answer[i]);
        }
    }
}
