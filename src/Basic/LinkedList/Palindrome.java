package Basic.LinkedList;

import java.util.Stack;

public class Palindrome {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        Stack<Integer> stack = new Stack<>();
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null) slow = slow.next;

        while(slow != null) {
            if(slow.val != stack.pop()) return false;
            slow = slow.next;
        }

        return true;
    }


    public static void main(String[] args) {
        Palindrome test = new Palindrome();
        ListNode head = test.new ListNode(1);
        head.next = test.new ListNode(2);
        head.next.next = test.new ListNode(3);
        head.next.next.next = test.new ListNode(2);
        head.next.next.next.next = test.new ListNode(1);

        System.out.println(test.isPalindrome(head));
    }
}

/*

Thinking:
1) Runner 기법

- LinkedList 는 순회하면서 인덱스를 탐색하기 때문에 두 개의 포인터를 사용하는 기법
     index
  a : 1 -> 2 -> 3 ..  // n
  b : 1 -> 3 -> 5 ..  // 2n - 1

*/