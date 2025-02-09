package LeetCode.stack.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

//public class NestedIteratorTest implements Iterator<Integer> {
public class NestedIteratorTest {

    Integer value;
    List<NestedIteratorTest> list;
    Stack<NestedIteratorTest> stack = new Stack<>();

    public NestedIteratorTest() {
        this.list = new ArrayList<>();
    }

    public NestedIteratorTest(int value) {
        this.value = value;
    }

    public NestedIteratorTest(List<NestedIteratorTest> list){
        flattenList(list);
    }

    public void add(NestedIteratorTest ni) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        this.list.add(ni);
    }

    public boolean isInteger(){
        return value != null;
    }

    public Integer getInteger(){
        return value;
    }

    public List<NestedIteratorTest> getList() {
        return list;
    }


    private void flattenList(List<NestedIteratorTest> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    public static void main(String[] args) {
        List<NestedIteratorTest> nestedList = new ArrayList<>();
        NestedIteratorTest ni1 = new NestedIteratorTest();
        ni1.add(new NestedIteratorTest(1));
        ni1.add(new NestedIteratorTest(2));
        nestedList.add(ni1);
        nestedList.add(new NestedIteratorTest(3));
        NestedIteratorTest ni2 = new NestedIteratorTest();
        ni2.add(new NestedIteratorTest(4));
        ni2.add(new NestedIteratorTest(5));
        nestedList.add(ni2);

        NestedIteratorTest i = new NestedIteratorTest(nestedList);
//        while (i.hasNext()) {
//            System.out.print(i.next() + " ");
//        }
    }
}
