package Programmers.Level3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class RogueUser {
    HashSet<HashSet<String>> ids = new HashSet<>();
    public void calculator(int L, ArrayList<String>[] banId, HashSet<String> set){
        if(L == banId.length){
            ids.add(set);
            return;
        }
        for(int i=0; i<banId[L].size(); i++){
            if(set.contains(banId[L].get(i))) continue;
            set.add(banId[L].get(i));
            calculator(L+1, banId, new HashSet<>(set));
            set.remove(banId[L].get(i));
        }
    }

    public int solution(String[] user_id, String[] banned_id) {
        ArrayList<String>[] banId = new ArrayList[banned_id.length];
        for(int i=0; i<banId.length; i++){
            banId[i] = new ArrayList<>();
        }
        for(int i=0; i<banned_id.length; i++){
            for(int j=0; j<user_id.length; j++){
                if(banned_id[i].length() != user_id[j].length()) continue;
                boolean flag = true;
                for(int k=0; k<user_id[j].length(); k++){
                    if(banned_id[i].charAt(k) == '*') continue;
                    if(banned_id[i].charAt(k) != user_id[j].charAt(k)){
                        flag = false;
                        break;
                    }
                }
                if(flag) banId[i].add(user_id[j]);
                //user_id[j].matches
            }
        }
        calculator(0, banId, new HashSet<>());
        return ids.size();
    }

    public static void main(String[] args) throws IOException {
        RogueUser ru = new RogueUser();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"*rodo", "*rodo", "******"};
        bw.write(ru.solution(user_id, banned_id)+"");
        bw.flush();
    }
}
/*
feed back:

[ Question ]
HashSet<String> ids = new HashSet<>(); 에서 아래 코드로 변환 수정하니 테스트 통과함
HashSet<HashSet<String>> ids = new HashSet<>();

[ Why ]
HashSet은 무작위로 저장하기 때문에 순서를 보장해주지 않는다.


[ More Things ]
- Deep Copy
- LinkedHashSet은 add 순서를 보장 함
- 정규표현식
String reg = banned_id[i].replace("*", "[\\w\\d]");
\\w : 문자만, \\W : 문자가 아닌경우에만
\\d : 숫자만, \\D : 숫자가 아닌경우에만

 */
