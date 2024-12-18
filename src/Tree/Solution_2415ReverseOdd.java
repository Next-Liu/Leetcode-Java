package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_2415ReverseOdd {
    public TreeNode reverseOddLevels(TreeNode root) {
        /**
         * 翻转满二叉树中每个奇数层的节点值。
         */
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<TreeNode>> ans = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                temp.add(node);
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
            if (j % 2 == 1) {
                List<TreeNode> treeNodes = ans.get(j);
                for (int k = 0; k < treeNodes.size() / 2; k++) {
                    TreeNode temp = treeNodes.get(k);
                    int tempVal = temp.val;
                    temp.val = treeNodes.get(treeNodes.size()-1-k).val;
                    treeNodes.get(treeNodes.size()-1-k).val = tempVal;
                }
            }
        }
        return root;
    }
}
