package Tree;

public class Solution_2331 {
    /**
     * 叶子结点：0 or 1     (0:false  1:true)
     * 非叶子结点：2 or 3  （2：OR 3：AND）
     * 如果节点是个叶子节点，那么节点的 值 为它本身，即 True 或者 False 。
     * 否则，计算 两个孩子的节点值，然后将该节点的运算符对两个孩子值进行 运算 。
     * OR                         OR                TRUE
     * TRUE       AND               TRUE   FALSE
     * FALSE  TRUE
     */
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 1;
        } else {
            boolean left = evaluateTree(root.left);
            boolean right = evaluateTree(root.right);
            if (root.val == 2) {
                return left || right;
            } else {
                return left && right;
            }
        }

    }

}
