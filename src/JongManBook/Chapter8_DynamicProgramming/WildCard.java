package JongManBook.Chapter8_DynamicProgramming;

import java.io.*;

public class WildCard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            String wc = br.readLine();
            int n = Integer.parseInt(br.readLine());
            for(int j=0; j<n; j++){
                String test = br.readLine();
                if(solve(wc, test)) bw.write(test + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean solve(String wc, String str){
        while(0 < wc.length() && 0 < str.length() && (wc.charAt(0) == '?' || str.charAt(0) == wc.charAt(0))){
            return solve(wc.substring(1), str.substring(1));
        }
        //패턴이 끝에 도달하여 끝난 경우 : 문자열도 끝났어야 대응되는 경우
        if(0 == wc.length()) return 0 == str.length();
        //*를 만나서 끝난 경우 : *에 몇 글자를 대응해야 할지 재귀 호출하면서 확인한다.
        if(wc.charAt(0) == '*'){
            if(solve(wc.substring(1), str) || (str.length() > 0 && solve(wc, str.substring(1))))
                return true;
        }

        return false;
    }
}
/*
위의 풀이 방법 O(N^2) 방법

TEST CASE:
2
he?p
3
help
heap
helpp
*p*
3
help
papa
hello

==>
heap
help
help
papa
 */

/* O(N^3) 방법
public static boolean solve(String wc, String str){
        int pos = 0;
        while(pos < wc.length() && pos < str.length() && (wc.charAt(pos) == '?' || str.charAt(pos) == wc.charAt(pos))){
            ++pos;
        }
        //패턴이 끝에 도달하여 끝난 경우 : 문자열도 끝났어야 대응되는 경우
        if(pos == wc.length()) return pos == str.length();
        //*를 만나서 끝난 경우 : *에 몇 글자를 대응해야 할지 재귀 호출하면서 확인한다.
        if(wc.charAt(pos) == '*'){
            for(int skip = 0; pos+skip <= str.length(); ++skip){
                if(solve(wc.substring(pos+1), str.substring(pos+skip)))
                    return true;
            }
        }

        return false;
    }
 */