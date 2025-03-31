package LinkedList;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // 1. 找到链表的中间节点
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
        ListNode pre = null;
        ListNode cur = slow.next;
        while (cur!=null){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        //pre是第二段链表的头结点
        slow.next = null;
        ListNode firstHead = head;
        while(pre!=null){
            ListNode temp1 = firstHead.next;
            ListNode temp2 = pre.next;
            pre.next = temp1;
            firstHead.next = pre;
            pre = temp2;
            firstHead = temp1;
        }
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");


        // 2. 反转后半部分链表
        ListNode secondHalf = reverseList(slow.next);
        slow.next = null; // 断开前半部分和后半部分

        // 3. 交替合并两个链表
        ListNode firstHalf = head;
        while (secondHalf != null) {
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;
            firstHalf.next = secondHalf;
            secondHalf.next = temp1;
            firstHalf = temp1;
            secondHalf = temp2;
        }
    }

    // 反转链表
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // 打印链表
    public void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // 创建链表 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReorderList reorderList = new ReorderList();
        System.out.println("原链表：");
        reorderList.printList(head);

        // 重组链表
        reorderList.reorderList(head);

//        System.out.println("重组后的链表：");
//        reorderList.printList(head);
    }
}
