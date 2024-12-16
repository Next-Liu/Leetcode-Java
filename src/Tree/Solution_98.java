package Tree;

/**
 * @version 1.0
 * @auther 刘庆延
 * @email 2291572118@qq.com
 */


public class Solution_98 {
    public TreeNode findLeft(TreeNode root) {  //找到左子树的最右节点
        if (root.left == null) {
            return root;
        }
        return findLeft(root.left);
    }

    public TreeNode findRight(TreeNode root) {  //找到右子树的最左节点
        if (root.right == null) {
            return root;
        }
        return findRight(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        if (root.right != null && root.val >= findLeft(root.right).val) {
            return false;
        }
        if (root.left != null && root.val <= findRight(root.left).val) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }
}
