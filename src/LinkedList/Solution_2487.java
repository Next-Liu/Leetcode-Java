package LinkedList;

import java.util.LinkedList;

public class Solution_2487 {
    public ListNode removeNodes(ListNode head) {
        // 创建一个rightMax数组，用于存储每个节点右侧的最大值
        // 计算链表长度
        int length = 0;
        // 创建一个双向链表存储结构
        LinkedList<Integer> list = new LinkedList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
            length++;
        }
        int[] rightMax = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            rightMax[i] = i == length - 1 ? list.get(i) : Math.max(list.get(i), rightMax[i + 1]);
        }
        ListNode dummyNode = new ListNode(0, head);
        ListNode cur = dummyNode;
        int i = 0;
        while (cur.next != null) {
            if (cur.next.val < rightMax[i]) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
            i++;
        }
        return dummyNode.next;
    }
}
