package Tree;

public class Solution_101 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;  //其中一个为空，另一个不为空返回false 否则返回true
        }
        return p.val == q.val && isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return isSameTree(root.left, root.right);
    }
}