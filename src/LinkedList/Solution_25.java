package LinkedList;

/**
 * @version 1.0
 * @auther 刘庆延
 * @email 2291572118@qq.com
 */

// 链表可以分为三部分 已翻转 待翻转 未翻转 确定好每次翻转的起始和终止位置
public class Solution_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        ListNode end = res;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return res.next;
    }
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode q;
        while (cur != null) {
            q = cur.next;
            cur.next = pre;
            pre = cur;
            cur = q;
        }
        return pre;
    }

    public static void main(String[] args) {
        Solution_25 solution_25 = new Solution_25();
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i < 6; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode res = solution_25.reverseKGroup(head, 4);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
