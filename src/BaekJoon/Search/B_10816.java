package BaekJoon.Search;

import java.io.*;

public class B_10816 {
    static int[] negative = new int[10000001];
    static int[] positive = new int[10000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        for(String s : str){
            int num = Integer.parseInt(s);
            if(num < 0){
                negative[Math.abs(num)]++;
            } else {
                positive[num]++;
            }
        }
        int m = Integer.parseInt(br.readLine());
        str = br.readLine().split(" ");
        for(String s : str){
            int num = Integer.parseInt(s);
            if(num < 0){
                sb.append(negative[Math.abs(num)]).append(" ");
            } else {
                sb.append(positive[num]).append(" ");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
