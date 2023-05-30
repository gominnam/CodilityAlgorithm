package Programmers.Level3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class JewelShopping {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        answer[1] = gems.length;
        Set<String> set = new HashSet<>();
        for(int i=0; i<gems.length; i++){
            set.add(gems[i]);
        }
        int gemTypeCnt = set.size();
        int ptr = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<gems.length; i++){
            map.put(gems[i], map.getOrDefault(gems[i], 0)+1);
            while(map.size() == gemTypeCnt){
                if(i-ptr < answer[1]-answer[0]){
                    answer[0] = ptr+1;
                    answer[1] = i+1;
                }
                String frontGem = gems[ptr++];
                map.put(frontGem, map.get(frontGem)-1);
                if(map.get(frontGem) == 0) map.remove(frontGem);
            }
        }

        return answer;
    }

    public static void main(String[] args){
        JewelShopping js = new JewelShopping();
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        for(int i : js.solution(gems)){
            System.out.print(i + " ");
        }
    }
}
