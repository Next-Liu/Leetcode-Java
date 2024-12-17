package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_199RightSideView {
    List<List<Integer>> ans;
    LinkedList<TreeNode> queue;
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        ans = new ArrayList<>();
        queue = new LinkedList<>();
        if (root == null) {
            return res;
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
        for (List<Integer> list : ans) {
            if (list.size()>1){
                res.add(list.get(list.size()-1));
            }else {
                res.add(list.get(0));
            }
        }
        return res;
    }
}
