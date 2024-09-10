package LinkedList;

/**
 * @version 1.0
 * @auther 刘庆延
 * @email 2291572118@qq.com
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution_24 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = new ListNode(-1, null);
        ListNode cur = head;
        ListNode q;
        while (cur != null) {
            q = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = q;
        }
        return pre.next;
    }
}
