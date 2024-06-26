package BaekJoon.Array;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class CQ_1021 {

    public static void solution(int N, int M, int[] target) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }
        int totalMoveCount = 0;
        for (int i = 0; i < M; i++) {
            while (true) {
                int index = 0;
                Iterator<Integer> it = deque.iterator();
                while (it.hasNext()) {
                    if (it.next() == target[i]) {
                        break;
                    }
                    index++;
                }
                if (index == 0) {
                    deque.pollFirst();
                    break;
                } else if (index > deque.size() / 2) {
                    deque.addFirst(deque.pollLast());
                    totalMoveCount++;
                } else {
                    deque.addLast(deque.pollFirst());
                    totalMoveCount++;
                }
            }
        }
        System.out.println(totalMoveCount);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] elements = new int[m];
        for (int i = 0; i < m; i++) {
            elements[i] = Integer.parseInt(st.nextToken());
        }
        solution(n, m, elements);
    }
}

/*
-ref: https://www.acmicpc.net/problem/1021
deque

TEST CASE:
1)
32 6
27 16 30 11 6 23

==> 59

2)
10 3
2 9 5

=> 8

---------------------------------------------------------------------------------
Deque?
1) 구현
- Deque<Integer> deque = new ArrayDeque<>();
    - 내부적으로 배열을 사용하여 데이터를 저장합니다. 이로 인해 ArrayDeque는 인덱스를 통한 빠른 데이터 접근이 가능합니다.
    - 배열의 크기를 동적으로 조절하므로, 큐의 크기가 변동하는 경우에도 효율적으로 메모리를 사용할 수 있습니다.
    - 원소를 추가하거나 제거할 때 배열의 복사가 필요할 수 있으므로, 이러한 연산의 시간 복잡도는 O(N)이 될 수 있습니다.

- Deque<Integer> deque = new LinkedList<>();
    - 내부적으로 이중 연결 리스트를 사용하여 데이터를 저장합니다. 이로 인해 LinkedList는 데이터의 추가와 제거가 O(1)의 시간 복잡도로 가능합니다.
    - 그러나 LinkedList는 인덱스를 통한 데이터 접근이 O(N)의 시간 복잡도를 가집니다. 이는 각 원소가 메모리의 임의의 위치에 저장되므로, 특정 원소에 접근하려면 리스트를 순차적으로 탐색해야 하기 때문입니다.
    - 또한, LinkedList는 각 원소마다 추가적인 메모리를 사용하여 다음과 이전 원소의 참조를 저장합니다. 이로 인해 LinkedList는 ArrayDeque보다 더 많은 메모리를 사용할 수 있습니다.

- 정리: 큐의 크기가 자주 변동하고 원소의 추가와 제거가 빈번하게 발생하는 경우에는 LinkedList를 사용을 고려하고
       반면에, 원소의 추가와 제거보다 원소의 접근이 더 자주 발생하는 경우에는 ArrayDeque를 사용


2) 사용
offerFirst(E e): 이 메서드는 주어진 요소를 덱의 앞쪽에 추가합니다. 덱의 용량이 제한되어 있고 덱이 꽉 차 있을 경우, 이 메서드는 false를 반환합니다.
offerLast(E e): 이 메서드는 주어진 요소를 덱의 뒤쪽에 추가합니다. 덱의 용량이 제한되어 있고 덱이 꽉 차 있을 경우, 이 메서드는 false를 반환합니다.
pollFirst(): 이 메서드는 덱의 앞쪽에서 요소를 제거하고 반환합니다. 덱이 비어 있을 경우, 이 메서드는 null을 반환합니다.
pollLast(): 이 메서드는 덱의 뒤쪽에서 요소를 제거하고 반환합니다. 덱이 비어 있을 경우, 이 메서드는 null을 반환합니다.
peekFirst(): 이 메서드는 덱의 앞쪽에 있는 요소를 반환하지만 제거하지는 않습니다. 덱이 비어 있을 경우, 이 메서드는 null을 반환합니다.
peekLast(): 이 메서드는 덱의 뒤쪽에 있는 요소를 반환하지만 제거하지는 않습니다. 덱이 비어 있을 경우, 이 메서드는 null을 반환합니다.
isEmpty(): 이 메서드는 덱이 비어 있는지 확인합니다. 덱이 비어 있으면 true를, 그렇지 않으면 false를 반환합니다.
size(): 이 메서드는 덱에 있는 요소의 수를 반환합니다.

iterator(): 이 메서드는 덱의 요소를 반복하는 반복자를 반환합니다. 이 반복자는 덱의 앞쪽에서 뒤쪽으로 요소를 반복합니다.
    - hasNext(): 이 메서드는 반복자가 다음 요소를 가리키고 있는지 확인합니다. 다음 요소가 있으면 true를 반환하고, 그렇지 않으면 false를 반환합니다.
    - next(): 이 메서드는 반복자가 현재 가리키고 있는 요소를 반환하고, 반복자를 다음 요소로 이동시킵니다.
    - remove(): 이 메서드는 next() 메서드로 반환된 마지막 요소를 덱에서 제거합니다.

 */