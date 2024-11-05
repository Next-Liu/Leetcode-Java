package LinkedList;


public class Solution_206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode p = cur.next;
        ListNode q = null;
        cur.next = null;
        while (p!=null){
            q = p.next;
            p.next = cur;
            cur = p;
            p = q;
        }
        return head;
    }
}
