package Programmers.Level2;

import java.util.*;

public class MenuRenewer {
    static ArrayList<String> setMenus;

    public static void combi(char[] menu, int s, int curLen, int setMenuLen, String setMenu){
        if(curLen == setMenuLen) {
            setMenus.add(setMenu);
        }
        else{
            for(int i=s; i<menu.length; i++){
                combi(menu, i+1, curLen+1, setMenuLen, setMenu+menu[i]);
            }
        }
    }

    public static String[] solution(String[] orders, int[] course) {
        String[] answer;
        setMenus = new ArrayList<>();

        for(String o : orders){
            char[] menu = o.toCharArray();
            Arrays.sort(menu);
            for(int c : course){
                combi(menu, 0, 0 , c, "");
            }
        }

        Map<String, Integer> map = new HashMap<>();
        for(String key : setMenus){
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
        entries.sort((o1, o2) -> map.get(o2.getKey()) - map.get(o1.getKey()));

        ArrayList<String> ans = new ArrayList<>();
        for(int i=0; i<course.length; i++){
            int maxValue = 0;
            for(Map.Entry<String, Integer> e : entries){
                if(map.get(e.getKey()) >= 2 && e.getKey().length() == course[i]){
                    if(map.get(e.getKey()) >= maxValue){
                        ans.add(e.getKey());
                        maxValue = e.getValue();
                    }
                }
            }
        }
        Collections.sort(ans);
        answer = new String[ans.size()];
        ans.toArray(answer);

        return answer;
    }

    public static void main(String args[]){
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        String[] a = solution(orders, course);

        int b = 10;
    }
}
/*
메뉴 리뉴얼

TEST CASE:
orders	course	result
["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]	    [2,3,4]	    ["AC", "ACDE", "BCFG", "CDE"]
["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]	[2,3,5]	    ["ACD", "AD", "ADE", "CD", "XYZ"]
["XYZ", "XWY", "WXA"]	                            [2,3,4]	    ["WX", "XY"]

 */