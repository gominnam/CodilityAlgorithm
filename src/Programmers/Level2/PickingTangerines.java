package Programmers.Level2;

import java.util.*;

public class PickingTangerines {

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> box = new HashMap<>();
        for(int t : tangerine){
            box.put(t, box.getOrDefault(t, 0)+1);
        }
        List<Integer> keySet = new ArrayList<>(box.keySet());
        keySet.sort(new Comparator<Integer>(){ //Lamda: keySet.sort((o1, o2) -> box.get(o2).compareTo(box.get(o1)));
            @Override
            public int compare(Integer o1, Integer o2){
                return box.get(o2).compareTo(box.get(o1));
            }
        });
        for(int i : keySet){
            if(k < 1) break;
            k -= box.get(i);
            answer++;
        }
        return answer;
    }

    public static void main(String[] args){
        PickingTangerines pt = new PickingTangerines();
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        System.out.print(pt.solution(k, tangerine));
    }
}
