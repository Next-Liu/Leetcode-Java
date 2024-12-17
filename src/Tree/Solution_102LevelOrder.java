package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_102LevelOrder {
    List<List<Integer>> ans;
    LinkedList<TreeNode> queue;

    public List<List<Integer>> levelOrder(TreeNode root) {
        ans = new ArrayList<>();
        queue = new LinkedList<>();
        if (root == null) {
            return ans;
        }
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
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        root.left = node9;
        root.right = node20;
        node20.left = node15;
        node20.right = node7;
        Solution_102LevelOrder ss = new Solution_102LevelOrder();
        List<List<Integer>> lists = ss.levelOrder(root);
    }
}
