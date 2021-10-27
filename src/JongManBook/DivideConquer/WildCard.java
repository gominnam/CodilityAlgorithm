package JongManBook.DivideConquer;

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
        int pos = 0;
        while(pos < wc.length() && pos < str.length() && (wc.charAt(pos) == '?' || str.charAt(pos) == wc.charAt(pos))){
            ++pos;
        }

        if(pos == wc.length()) return pos == str.length();

        if(wc.charAt(pos) == '*'){
            for(int skip = 0; pos+skip <= str.length(); ++skip){
                if(solve(wc.substring(pos+1), str.substring(pos+skip)))
                    return true;
            }
        }

        return false;
    }
}
/*
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
