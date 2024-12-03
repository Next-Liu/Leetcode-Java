package LinkedList;

/**
 * 将list1的a到b个结点删除后，list2插入（[a,b]）
 */
public class Solution_1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // 找到list1的start1和end1 list2的start2和end2
        ListNode cur1 = new ListNode(-1, list1);
        ListNode cur2 = list2;
        ListNode start1 = null, end1 = null;
        int i = -1, j = -1;
        while (cur1 != null) {
            cur1 = cur1.next;
            i++;
            if (i == (a - 1)) {
                start1 = cur1;
            } else if (i == (b + 1)) {
                end1 = cur1;
            }
        }
        ListNode start2 = list2;
        while (cur2.next != null) {
            cur2 = cur2.next;
        }
        ListNode end2 = cur2;
        // start1->start2 end2->end1
        start1.next = start2;
        end2.next = end1;
        return list1;
    }

    public static void main(String[] args) {
        Solution_1669 solution_1669 = new Solution_1669();
        ListNode head1 = new ListNode(0);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(4);
        head1.next.next.next.next.next = new ListNode(5);
        ListNode head2 = new ListNode(1000000);
        head2.next = new ListNode(1000001);
        head2.next.next = new ListNode(1000002);
        head2.next.next.next = new ListNode(1000003);
        head2.next.next.next.next = new ListNode(1000004);
        head2.next.next.next.next.next = new ListNode(1000005);
        solution_1669.mergeInBetween(head1, 3, 4, head2);
        while (head1 != null) {
            System.out.println(head1.val);
            head1 = head1.next;
        }
    }
}
