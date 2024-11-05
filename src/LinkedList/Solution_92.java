package LinkedList;

public class Solution_92 {
    /**
     * 1->2->3->4->5
     * 1.next = 4
     * 2.next = 5
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        // p0指向待反转序列的上一个结点
        for (int i = 0; i < left - 1; i++) {
            p0 = p0.next;
        }
        ListNode pre = null;
        ListNode cur = p0.next;
        for (int j = 0; j < right - left + 1; j++) {
            ListNode nxt = cur.next;
            cur.next = pre;  //核心步骤
            pre = cur;
            cur = nxt;
        }
        //原始：1->2->3->4->5
        //循环完：1->2
        // 4->3->2->null cur=ListNode(5) p0=ListNode(1) 故要让2->5需要p0.next.next = cur
        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;
    }
}
