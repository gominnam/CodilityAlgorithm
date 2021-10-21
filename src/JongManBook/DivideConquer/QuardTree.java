package JongManBook.DivideConquer;

import java.io.*;

public class QuardTree {
    static String str;
    static int pointer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        str = br.readLine();
        String answer = reverse(0);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static String reverse(int index){
        if(str.length() == 0) return "";
        char head = str.charAt(index);
        if(head == 'b' || head == 'w')
            return head + "";
        String upperLeft = reverse(++pointer);
        String upperRight = reverse(++pointer);
        String lowerLeft = reverse(++pointer);
        String lowerRight = reverse(++pointer);

        return "x" + lowerLeft + lowerRight + upperLeft + upperRight;
    }
}
/*
    ##분할정복 쿼드트리

TEST CASE:

w

==> w

xbwwb

==> xwbbw

xbwxwbbwb

==> xxbwwbbbw

xxwwwbxwxwbbbwwxxxwwbbbwwwwbb

==> xxwbxwwxbbwwbwbxwbwwxwwwxbbwb

 */