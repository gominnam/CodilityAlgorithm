package LeetCode.stack.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {

    private Integer value;
    private List<NestedIterator> list;

    public NestedIterator() {
        this.list = new ArrayList<>();
    }

    public NestedIterator(int value) {
        this.value = value;
    }

    public boolean isInteger() {
        return value != null;
    }

    public Integer getInteger() {
        return value;
    }

    public void setInteger(int value) {
        this.value = value;
    }

    public void add(NestedIterator ni) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        this.list.add(ni);
    }

    public List<NestedIterator> getList() {
        return list;
    }

    // Flatten Nested List Iterator
    private final Stack<NestedIterator> stack = new Stack<>();

    public NestedIterator(List<NestedIterator> nestedList) {
        flattenList(nestedList);
    }

    private void flattenList(List<NestedIterator> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedIterator current = stack.peek();
            if (current.isInteger()) {
                return true;
            }
            stack.pop();
            flattenList(current.getList());
        }
        return false;
    }

    public static void main(String[] args) {
        // Example usage
        List<NestedIterator> nestedList = new ArrayList<>();
        NestedIterator ni1 = new NestedIterator();
        ni1.add(new NestedIterator(1));
        ni1.add(new NestedIterator(2));
        nestedList.add(ni1);
        nestedList.add(new NestedIterator(3));
        NestedIterator ni2 = new NestedIterator();
        ni2.add(new NestedIterator(4));
        ni2.add(new NestedIterator(5));
        nestedList.add(ni2);

        NestedIterator i = new NestedIterator(nestedList);
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
    }
}

/*

Thinking:
: 20분간 고민 해보고 구현하다 참조 소스 보고 구현.
: Iterator의 hasNext()와 next() 메소드를 구현하는 것이 핵심.
: Stack 자료구조를 활용하여 리스트 인경우 Stack에 쌓아가면서 Integer를 꺼내는게 핵심 // todo: deque로 구현해보기

: 현재 위치를 가리키는 포인터를 가지고 있어야 한다.
: 뒤에서부터 stack으로 쌓고 앞에서부터 꺼내는 방식으로 구현해야 한다.
    : 리스트를 만나면 다시 평탄화 하여 stack에 넣어준다.


-ref: https://leetcode.com/problems/flatten-nested-list-iterator/

 */