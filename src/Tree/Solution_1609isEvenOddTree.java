package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_1609isEvenOddTree {
    List<List<Integer>> ans;
    LinkedList<TreeNode> queue;

    public boolean isEvenOddTree(TreeNode root) {
        /**
         * 奇偶数条件：
         * 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
         * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
         * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
         */
        ans = new ArrayList<>();
        queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {  //注意：这是个循环
                TreeNode node = queue.removeFirst();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(temp);
        }
        for (int j = 0; j < ans.size(); j++) {
            List<Integer> list = ans.get(j);
            if (list.size() == 1) {
                if (j % 2 == 0) {
                    if (list.get(0) % 2 != 1) {
                        return false;
                    }
                }
                if (j % 2 != 0) {
                    if (list.get(0) % 2 != 0) {
                        return false;
                    }
                }
            }else{
                if (j % 2 == 0) {
                    for (int k = 0; k < list.size() - 1; k++) {
                        if (list.get(k) % 2 != 1 || list.get(k) >= list.get(k + 1)||list.get(k+1) % 2 != 1 ) {
                            return false;
                        }
                    }
                }
                if (j % 2 != 0) {
                    for (int k = 0; k < list.size() - 1; k++) {
                        if (list.get(k) % 2 != 0 || list.get(k) <= list.get(k + 1)||list.get(k+1) % 2 != 0) {
                            return false;
                        }
                    }
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node2 = new TreeNode(12);
        TreeNode node3 = new TreeNode(8);
        root.left = node2;
        root.right = node3;
        Solution_1609isEvenOddTree ss = new Solution_1609isEvenOddTree();
        ss.isEvenOddTree(root);
    }
}
