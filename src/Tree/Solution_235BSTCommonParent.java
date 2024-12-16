package Tree;

public class Solution_235BSTCommonParent {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 如果p和q的值小于当前结点：公共祖先在左子树
         * 如果p和q的值大于当前结点：公共祖先在右子树
         * 返回当前结点
         */
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
