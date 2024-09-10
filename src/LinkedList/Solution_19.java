package LinkedList;

public class Solution_19 {
    public class ListNode {
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

    public class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode pre = new ListNode(0, head);
            if (head.next == null) {
                pre.next = head.next;
                return pre.next;
            }
            ListNode low, fast;
            low = pre;
            fast = head;
            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                low = low.next;
                fast = fast.next;
            }
            low.next = low.next.next;
            return pre.next;
        }
    }
}