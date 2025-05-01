package Programmers.kakao.blind_2018;

import java.util.*;

public class Compression {

    final static int CHARACTER_ALPHABET = 64;

    public int[] solution(String msg) {
        int idx = 1;
        Map<String, Integer> cMap = new HashMap<>();
        for(;idx <= 26; idx++){
            cMap.put(Character.toString(idx + CHARACTER_ALPHABET), idx);
        }

        List<Integer> list = new ArrayList<>();
        String s = msg.charAt(0) + "";
        for(int i = 1; i < msg.length(); i++){
            char c = msg.charAt(i);
            String nKey = s + c;
            if(cMap.containsKey(nKey)) {
                s = nKey;
            } else {
                list.add(cMap.get(s));
                cMap.put(nKey, idx++);
                s = c + "";
            }
        }

        list.add(cMap.get(s));

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Compression c = new Compression();
//        String s = "KAKAO"; // 11, 1, 27, 15
        String s = "TOBEORNOTTOBEORTOBEORNOT"; // 20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34
        int[] result = c.solution(s);
        System.out.println(Arrays.toString(result));
    }
}

/*

list.toArray(); 는 Integer[] 형으로 변환 그러므로 stream 필요 int[]로 하기 위해선

 */
