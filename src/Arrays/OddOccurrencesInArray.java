package Arrays;
import java.util.*;

public class OddOccurrencesInArray {
    public int solution(int[] A) {
        HashSet<Integer> hs = new HashSet<>();

        for (int i : A) {
            if (hs.contains(i)) hs.remove(i);
            else hs.add(i);
        }

        int answer = 0;
        for(int a : hs){
            answer = a;
        }

        return answer;
    }
}

/* 피드백
1. HashSet에 값이 있으면 remove, 없으면 add
2. 그러면 짝이 없는 값 하나가 남는데 갖고오는데 애를 먹었다. 어차피 1개가 남을테니 foreach문으로 구현했다.


결론: 처음에 문제를 잘못 이해했다. 홀수번째, 짝수번째 인덱스끼리 pair를 구하고 짝이 없는 것을 return하는 줄 알았다.
     영어 독해 문제가 컸다.
     HashSet말고 다른 자료구조를 생각해보자. 값을 갖고오는데 header가 없어서 갖고올 때 애먹었다.
 */