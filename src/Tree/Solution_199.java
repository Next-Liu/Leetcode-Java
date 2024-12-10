package Tree;

import java.util.ArrayList;
import java.util.List;

public class Solution_199 {
    /**
     * 在递归时记录深度，如果深度和答案长度相同则记录
     * 1
     * 2 3
     * 4
     * 5
     * 答案是[1,3,4,5]
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if(root!=null){
            dfs(root, 0, ans);
        }
        return ans;
    }

    public void dfs(TreeNode root, int depth, List<Integer> ans) {
        if (depth == ans.size()) {
            ans.add(root.val);
        }
        if (root.right!=null){
            dfs(root.right, depth + 1, ans);
        }
        if (root.left!=null){
            dfs(root.left, depth + 1, ans);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node4.left = node5;
        Solution_199 s = new Solution_199();
        List<Integer> integers = s.rightSideView(root);
        System.out.println(integers);
    }
}
