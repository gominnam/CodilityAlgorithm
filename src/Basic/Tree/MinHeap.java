package Basic.Tree;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MinHeap {
    private ArrayList<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    public void insert(int value) {
        heap.add(value); // 마지막에 추가
        heapifyUp(heap.size() - 1);
    }

    public int extractMin() {
        if(heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if(!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return min;
    }

    public int getMin() {
        if(heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return heap.get(0);
    }

    private void heapifyUp(int i) {
        int parent = (i - 1) / 2; // 인덱스 계산
        while(i > 0 && heap.get(i) < heap.get(parent)) {
            swap(i, parent);
            i = parent;
            parent = (i - 1) / 2;
        }
    }

    private void heapifyDown(int i) { // root에서 정렬
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;
        if(left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }
        if(right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }
        if(smallest != i) {
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j){
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public static void main(String[] args){
        MinHeap minHeap = new MinHeap();
        minHeap.insert(12);
        minHeap.insert(7);
        minHeap.insert(6);
        minHeap.insert(10);
        minHeap.insert(8);
        minHeap.insert(20);

        System.out.println(minHeap.getMin()); // 1
        System.out.println(minHeap.extractMin()); // 1
        System.out.println(minHeap.getMin()); // 2
    }
}

/*

# Binary Heap(이진 힙)

- 완전 이진 트리의 일종
- 최대 힙(Max Heap)과 최소 힙(Min Heap)이 있다.
- 최대 힙(Max Heap) : 부모 노드의 키 값이 자식 노드의 키 값보다 항상 큰 힙
- 최소 힙(Min Heap) : 부모 노드의 키 값이 자식 노드의 키 값보다 항상 작은 힙
- 주로 우선순위 큐를 구현하는데 사용된다.
- 삽입과 삭제 연산의 시간 복잡도는 O(log n) 이다.


# method
- insert(value) : 힙에 원소를 삽입한다.
- extractMin() : 최소 원소를 삭제하고 반환한다.
- getMin() : 최소 원소를 반환한다.
- heapifyUp(i) : i번째 노드를 부모 노드와 비교하여 위치를 바꾼다.
- heapifyDown(i) : i번째 노드를 자식 노드와 비교하여 위치를 바꾼다.
- swap(i, j) : i번째 노드와 j번째 노드의 위치를 바꾼다.


# index 구하기

- 부모 노드 인덱스: i번째 노드의 부모 노드 인덱스는 (i - 1) / 2로 계산됩니다.
- 왼쪽 자식 노드 인덱스: i번째 노드의 왼쪽 자식 노드 인덱스는 2 * i + 1로 계산됩니다.
- 오른쪽 자식 노드 인덱스: i번째 노드의 오른쪽 자식 노드 인덱스는 2 * i + 2로 계산됩니다.

 */