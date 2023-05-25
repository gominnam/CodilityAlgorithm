package Programmers.Level3;

public class WordConversion {
    static boolean[] check;
    static boolean flag = false;
    static int answer = Integer.MAX_VALUE;

    public boolean isConversion(String a, String b){
        int cnt = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) cnt++;
        }

        if(cnt == 1) return true;
        return false;
    }

    public void dfs(int L, String w, String t, String[] words){
        if(w.equals(t)) {
            answer = Math.min(answer, L);
            flag = true;
            return;
        }
        for(int i=0; i<words.length; i++){
            if(check[i]) continue;
            if(isConversion(w, words[i])){
                check[i] = true;
                dfs(L+1, words[i], t, words);
                check[i] = false;
            }
        }
    }

    public int solution(String begin, String target, String[] words) {
        check = new boolean[words.length];
        dfs(0, begin, target, words);
        if(flag) return answer;
        return 0;
    }

    public static void main(String[] args){
        WordConversion wc = new WordConversion();
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.print(wc.solution(begin, target, words));
    }
}
/*
단어 변환

 */
