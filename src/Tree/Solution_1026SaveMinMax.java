package Tree;

public class Solution_1026SaveMinMax {
    private int ans = 0;

    public int maxAncestorDiff(TreeNode root) {
        /**
         * 找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
         * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
         * 保存路径中的最小节点值 mn 和最大节点值 mx。
         */
        dfs(root, root.val, root.val);
        return ans;
    }

    public void dfs(TreeNode root, int min, int max) {
        if (root == null)
            return;
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        ans = Math.max(ans, Math.max(max - root.val, root.val - min));
        dfs(root.left, min, max);
        dfs(root.right, min, max);
    }
}
