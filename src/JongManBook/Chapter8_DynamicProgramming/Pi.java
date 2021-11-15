package JongManBook.Chapter8_DynamicProgramming;

import java.io.*;

public class Pi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int C = Integer.parseInt(br.readLine());
        for(int i=0; i<C; i++){
            int p = Integer.parseInt(br.readLine());
            bw.write(solve(p) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve(int p){

    }
}
/*
TESTCASE:
5
12341234
11111222
12122222
22222222
12673939

==>
4
2
5
2
14

 */