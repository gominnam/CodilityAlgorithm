package Programmers.Level2;

import java.util.*;

public class ParcelDeliveryAndCollection {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<Integer> deliveryStack = new Stack<>();
        Stack<Integer> pickupStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (deliveries[i] > 0) deliveryStack.push(i);
            if (pickups[i] > 0) pickupStack.push(i);
        }

        while (!deliveryStack.isEmpty() || !pickupStack.isEmpty()) {
            int farthestDelivery = deliveryStack.isEmpty() ? 0 : deliveryStack.peek();
            int farthestPickup = pickupStack.isEmpty() ? 0 : pickupStack.peek();
            int farthest = Math.max(farthestDelivery, farthestPickup);

            answer += (farthest + 1) * 2L;

            int currentCapacity = cap;
            while (!deliveryStack.isEmpty() && currentCapacity > 0) {
                int idx = deliveryStack.peek();
                if (deliveries[idx] <= currentCapacity) {
                    currentCapacity -= deliveries[idx];
                    deliveryStack.pop();
                } else {
                    deliveries[idx] -= currentCapacity;
                    currentCapacity = 0;
                }
            }

            currentCapacity = cap;
            while (!pickupStack.isEmpty() && currentCapacity > 0) {
                int idx = pickupStack.peek();
                if (pickups[idx] <= currentCapacity) {
                    currentCapacity -= pickups[idx];
                    pickupStack.pop();
                } else {
                    pickups[idx] -= currentCapacity;
                    currentCapacity = 0;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        ParcelDeliveryAndCollection pdc = new ParcelDeliveryAndCollection();
        int cap = 2;
        int n = 7;
        int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
        int[] pickups = {0, 2, 0, 1, 0, 2, 0};
        System.out.println(pdc.solution(cap, n, deliveries, pickups));
    }
}

/*

Thinking:
1) Stack
- 배달 하고 나서 싣고 오는 것이므로 픽업을 시작할때는 항상 비어있다.
    - 배달하는 곳이 더 먼 경우: 먼 곳부터 수량이 가능할때까지 배달을 한다.
    - 핍업하는 곳이 더 먼 경우: 픽업하는 곳에 도달하기전에 미리 배달을 마친다.


-ref: https://school.programmers.co.kr/learn/courses/30/lessons/150369

 */
