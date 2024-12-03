package LinkedList;

import java.util.LinkedList;
import java.util.List;

public class Solution_2487Reverse {
    public ListNode removeNodes(ListNode head) {
        head = reverseList(head);
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val > cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return reverseList(head);
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = new ListNode(-1, head);
        while (head.next != null) {
            ListNode q = head.next;
            head.next = q.next;
            q.next = pre.next;
            pre.next = q;
        }
        return pre.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);
        Solution_2487Reverse solution = new Solution_2487Reverse();
        ListNode res = solution.reverseList(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
