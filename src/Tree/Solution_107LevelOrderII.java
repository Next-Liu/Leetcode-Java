package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution_107LevelOrderII {
    List<List<Integer>> ans;
    LinkedList<TreeNode> queue;

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        for (int j = 0; j < ans.size() / 2; j++) {
            List<Integer> temp = ans.get(j);
            ans.set(j, ans.get(ans.size() - 1 - j));
            ans.set(ans.size() - 1 - j, temp);
        }
        //Collections.reverse(ans);
        return ans;
    }
}
