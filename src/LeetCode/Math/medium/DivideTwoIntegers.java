package LeetCode.Math.medium;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        long longResult = ((long)dividend/(long)divisor);
        try{
            return Math.toIntExact(longResult);
        } catch(ArithmeticException e){
            return Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args){
        DivideTwoIntegers dti = new DivideTwoIntegers();
        System.out.println(dti.divide(-2147483648, -1));
    }
}

/*

Thinking:
1) Java에서 int
- int의 범위는 2^31 - 1 ~ -2^31
- 부호가 있는 범위와 없는 범위(0 ~ 2^31 - 1) 두 가지가 있다 그러므로 음의 최소값이 양의 최대값보다 1만큼 더 크다.


-ref: https://leetcode.com/problems/divide-two-integers/

 */