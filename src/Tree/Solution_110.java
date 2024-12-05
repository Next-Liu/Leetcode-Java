package Tree;

public class Solution_110 {
    public int Balance(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Balance(root.left);
        int right = Balance(root.right);
        //因为这里的left和right也可能代表以某个节点为根节点的子树的深度，所以要判断left和right是否为-1
        if (Math.abs(left - right) > 1 || left == -1 || right == -1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return Balance(root) != -1;
    }
}
