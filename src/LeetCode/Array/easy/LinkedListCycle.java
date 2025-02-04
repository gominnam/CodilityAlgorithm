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

    public boolean hasCycle_Floyd(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    public static void main(String[] args) {
        LinkedListCycle a = new LinkedListCycle();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(a.hasCycle(head));//true
        System.out.println(a.hasCycle_Floyd(head));//true

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

+ Floyd의 Tortoise and Hare 알고리즘
    - 두 포인터를 이용하여 한 포인터는 한번에 한칸씩, 다른 포인터는 한번에 두칸씩 이동한다.
    - slow 포인터는 한 번에 한 노드씩 이동하므로, slow가 n번째 노드에 도달할 때 fast 포인터는 2n번째 노드에 도달하므로 두 포인터는 결국 만나게 된다.
    - 기존 val을 변경 없이 사용하므로 더 안정적, 공간복잡도 또한 O(1)이다.

-ref: https://leetcode.com/problems/linked-list-cycle/

 */