package Tree;

public class Solution_1448 {

    public int dfs(TreeNode root, int mx) {
        if (root == null) {
            return 0;
        }
        // 保存根节点到当前节点之前，路径上的最大节点值。
        int left = dfs(root.left, Math.max(root.val, mx));
        int right = dfs(root.right, Math.max(root.val, mx));
        return left + right + (mx <= root.val ? 1 : 0); //返回以当前结点为根节点有几个goodNodes
    }

    public int goodNodes(TreeNode root) {
        return dfs(root,Integer.MIN_VALUE);
    }
}
