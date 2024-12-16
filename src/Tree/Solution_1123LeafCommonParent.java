package Tree;

public class Solution_1123LeafCommonParent {
    TreeNode ans;
    int maxDepth = -1;

    public int dfs(TreeNode node, int depth) {
        if (node == null) {
            maxDepth = Math.max(depth, maxDepth);
            return depth;
        }
        int leftLeafDepth = dfs(node.left, depth + 1);
        int rightLeafDepth = dfs(node.right, depth + 1);
        if (leftLeafDepth == maxDepth && rightLeafDepth == maxDepth) {
            ans = node;
        }
        return Math.max(leftLeafDepth, rightLeafDepth);// 返回当前子树最深叶节点的深度
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
//        设左子树最深叶节点的深度为 leftMaxDepth，右子树最深叶节点的深度为 rightMaxDepth。
//        如果 leftMaxDepth=rightMaxDepth=maxDepth，那么更新答案为当前节点。
        dfs(root, 0);
        return ans;

    }
}
