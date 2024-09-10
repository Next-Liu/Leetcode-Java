package LinkedList;

public class swap_24 {
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
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode pre = new ListNode(0, head);
            ListNode temp = pre;
            while (temp.next != null && temp.next.next != null){
                ListNode start = temp.next;
                ListNode end = temp.next.next;
                start.next = end.next;
                end.next = start;
                temp.next = end;
                temp = start;
            }
            return pre.next;
        }
    }
}
