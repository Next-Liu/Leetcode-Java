package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_103SerratedLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isOdd = true;
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            if (isOdd) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.get(size-i-1);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    temp.add(node.val);
                    queue.remove(size-i-1);
                }
            }
            if (!isOdd) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.get(size-i-1);
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    temp.add(node.val);
                    queue.remove(size-i-1);
                }
            }
            isOdd = !isOdd;
            ans.add(temp);
        }
        return ans;
    }
}
