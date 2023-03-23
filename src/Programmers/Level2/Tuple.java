package Programmers.Level2;

import java.util.*;

public class Tuple {
    public ArrayList<Integer> solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        String[] str = s.split("},");
        for(int i=0; i<str.length; i++){
            str[i] = str[i].replaceAll("[{}]", "");
        }
        Arrays.sort(str, new Comparator<String>(){
            public int compare(String o1, String o2){
                return Integer.compare(o1.length(), o2.length());
            }
        });
        for(String t : str){
            String[] tmpStr = t.split(",");
            for(String splitStr : tmpStr){
                if(!answer.contains(Integer.parseInt(splitStr))){
                    answer.add(Integer.parseInt(splitStr));
                }
            }
        }
        return answer;
    }

    public int[] solution2(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b) -> a.length()-b.length());//Lambda
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr){
            for(String s2 : s1.split(",")){
                if(set.add(s2)){
                    answer[idx++] = Integer.parseInt(s2);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Tuple t = new Tuple();
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        for(int i : t.solution2(s)){
            System.out.print(i + " ");
        }
    }
}

/*
[ Step ]

1. String을 잘 정제하여 사용할 수 있는 데이터로 변환
2. String을 정렬한다 <<
    ##) Arrays.sort(str,new Comparator<String>(){
            public int compare(String o1, String o2){

                return Integer.compare(o1.length(), o2.length());
            }
        });
 */