package Inflearn;

import java.util.Scanner;

public class Eratos {
    public int Solve(int n){
        int answer = 0;

        for(int i=2; i<=n; i++){
            if(isPrime(i)) answer++;
        }

        return answer;
    }

    public boolean isPrime(int n){
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0)  return false;
        }

        return true;
    }

    public static void main(String[] args){
        Eratos T = new Eratos();

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println(T.Solve(num));
    }
}

/*

현재의 수를 소수인지 확인하고 그 값의 배수를 flag를 주는 것을 에라토스의 체라고 한다.
public int solution(int n) {
    int answer = 0;
    int[] ch = new int[n + 1];
    for(int i=2; i<=n; i++){
        if(ch[i]==0){
            answer++;
            for(int j=i; j<=n; j=j+i) ch[j] = 1;
        }
    }
    return answer;
}

 */
