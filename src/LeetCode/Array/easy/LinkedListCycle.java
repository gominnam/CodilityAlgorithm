package LeetCode.Array.easy;

public class LinkedListCycle {

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode node = head;
        while (node.next != null) {
            if (node.val == Integer.MIN_VALUE) {
                return true;
            }
            node.val = Integer.MIN_VALUE;
            node = node.next;
        }

        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle a = new LinkedListCycle();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(a.hasCycle(head));//true

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        System.out.println(a.hasCycle(head));//true

        head = new ListNode(1);
        System.out.println(a.hasCycle(head));//false
    }
}

/*

Thinking:
- 방문한 노드는 Integer.MIN_VALUE로 표시한다. (val 범위가 -10^4 ~ 10^4 이므로 특정지을 수 있는 값) // 공간복잡도는 O(1) 새로운 메모리 할당이 없다.
- 노드를 순회하면서 방문한 노드인지 확인한다.


-ref: https://leetcode.com/problems/linked-list-cycle/

 */