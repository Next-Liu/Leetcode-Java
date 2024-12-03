package Tree;

public class Solution_111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0, right = 0;
        if (root.left != null) {
            left = minDepth(root.left);
        }
        if (root.right != null) {
            right = minDepth(root.right);
        }
        if (left == 0)
            return right + 1;
        if (right == 0)
            return left + 1;
        return Math.min(left, right) + 1;
    }
}
