package Inflearn.Greedy;

import java.util.*;

public class Wresler {
    static public class People implements Comparable<People>{
        int tall;
        int weight;
        public People(int t, int w){
            this.tall = t;
            this.weight = w;
        }

        @Override
        public int compareTo(People p){ //키 우선 내림차순
            if(this.tall == p.tall) return p.weight - this.weight;
            else return p.tall - this.tall;
        }
    }

    public static void main(String[] args){
        Wresler T = new Wresler();
        Scanner sc = new Scanner(System.in);
        ArrayList<People> arr = new ArrayList<>();
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr.add(new People(a, b));
        }

        Collections.sort(arr);
        int maxW = Integer.MIN_VALUE;
        maxW = arr.get(0).weight;
        int answer = 0;
        for(People p : arr){
            if(p.weight >= maxW) {
                maxW = p.weight;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
/*
설명

현수는 씨름 감독입니다. 현수는 씨름 선수를 선발공고를 냈고, N명의 지원자가 지원을 했습니다.

현수는 각 지원자의 키와 몸무게 정보를 알고 있습니다.

현수는 씨름 선수 선발 원칙을 다음과 같이 정했습니다.

“A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은(크고, 무겁다) 지원자가

존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.”

N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지 알아내는 프로그램을 작성하세요.


입력
첫째 줄에 지원자의 수 N(5<=N<=30,000)이 주어집니다.

두 번째 줄부터 N명의 흰돌 능력치와 검은돌 능력치 정보가 차례로 주어집니다.

각 선수의 흰돌능력치가 모두 다르고, 검은돌 능력치도 모두 다릅니다. 능력치 값은 1,000,000이하의 자연수입니다.


출력
첫째 줄에 바둑 선수로 뽑히는 최대 인원을 출력하세요.

TEST CASE:
5
172 67
183 65
180 70
170 72
181 60


==> 3
 */