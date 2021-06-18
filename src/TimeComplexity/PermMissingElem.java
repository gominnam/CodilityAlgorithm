package TimeComplexity;
import java.util.*;

public class PermMissingElem {
    public int solution(int[] A) {
        Arrays.sort(A);
        int index = 1;
        for(int i : A){
            if(i != index) return index;
            index++;
        }

        return index;
    }
}

/* 피드백

결론: 별다른 문제점 없었다. 정렬이 다 됐을 경우에 마지막 return 값 조건이 없어서 0을 넣어서 틀렸다.
      index를 return해주니까 pass 했다.
 */