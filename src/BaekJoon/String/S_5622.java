package BaekJoon.String;

import java.io.*;

public class S_5622 {
    enum Dial {
        A(2), B(2), C(2),
        D(3), E(3), F(3),
        G(4), H(4), I(4),
        J(5), K(5), L(5),
        M(6), N(6), O(6),
        P(7), Q(7), R(7), S(7),
        T(8), U(8), V(8),
        W(9), X(9), Y(9), Z(9);

        private int time;

        Dial(int time) {
            this.time = time;
        }

        public int getTime() {
            return time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String dial = br.readLine();
        int answer = dial.length();
        for(char c : dial.toCharArray()){
            answer += Dial.valueOf(String.valueOf(c)).getTime();
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}

/*

- enum 열거형 상수 사용하여 소스 간결화

 */
