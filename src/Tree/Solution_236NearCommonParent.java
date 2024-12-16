package Tree;

public class Solution_236NearCommonParent {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 当前结点：
         *     空结点 ：直接返回
         *     p/q结点：直接返回
         *     其他：左右子树均找到：返回当前结点
         *          只在左子树：返回递归左子树结果
         *          只在右子树：返回递归右子树结果
         *          左右子树均没找到：返回空节点
         */
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        } else {
            return null;
        }
    }
}
