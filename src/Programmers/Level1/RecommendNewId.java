package Programmers.Level1;

public class RecommendNewId {

    public static String solution(String new_id){
        String answer = "";

        new_id = new_id.toLowerCase();

        for(int i=0; i<new_id.length(); i++){
            if(('0' <= new_id.charAt(i) && new_id.charAt(i) <= '9') || ('a' <= new_id.charAt(i) && new_id.charAt(i) <= 'z')
                    || new_id.charAt(i) == '-' || new_id.charAt(i) == '_' || new_id.charAt(i) == '.'){
                answer += new_id.charAt(i);
            }
        }

        while(answer.contains("..")){
            answer = answer.replace("..", ".");
        }

        if(answer.length() >= 1 && answer.charAt(0) == '.') answer = answer.substring(1);
        if(answer.length() >= 1 && answer.charAt(answer.length()-1) == '.') answer = answer.substring(0, answer.length()-1);

        if(answer.equals("")) answer = "a";

        if(answer.length() > 15) answer = answer.substring(0, 15);
        if(answer.length() >= 1 && answer.charAt(answer.length()-1) == '.') answer = answer.substring(0, answer.length()-1);

        while(answer.length() <= 2){
            answer += answer.charAt(answer.length()-1);
        }

        return answer;
    }

    public static void main(String[] args){
        String result = solution("...!@BaT#*..y.abcdefghijklm..");
        System.out.println(result);
    }
}

/*
Level 1
코딩테스트 연습
2021 KAKAO BLIND RECRUITMENT
신규 아이디 추천
 */