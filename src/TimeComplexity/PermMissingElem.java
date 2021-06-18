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
