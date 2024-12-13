package Tree;

public class Solution_98BST {
    public boolean check(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }
        if (root.val >= right || root.val <= left) {
            return false;
        }
        boolean leftTree = check(root.left, left, root.val);
        boolean rightTree = check(root.right, root.val, right);
        return leftTree && rightTree;
    }

    public boolean isValidBST(TreeNode root) {
        return check(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

}
