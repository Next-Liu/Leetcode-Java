package Tree;

public class Solution_1080 {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        /**
         * 给你二叉树的根节点 root 和一个整数 limit ，请你同时删除树中所有 不足节点 ，并返回最终二叉树的根节点。
         * 假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为 不足节点 ，需要被删除。
         * 叶子节点，就是没有子节点的节点。
         *
         * 对于一个叶子节点 leaf，由于根到 leaf 的路径仅有一条，所以如果这条路径的元素和小于 limit，就删除 leaf。
         * 对于一个非叶节点 node，如果所有子节点都被删除，说明从该节点出发的路径均不满足 limit，因此可以删除；
         * 但只要有一个子节点保留下来，说明有一条路径满足条件，非叶节点也需要保留。
         */
        limit -= root.val;
        if (root.left == root.right) {
            if (limit > 0) {  //该条路径和小于limit
                return null;
            } else {
                return root;
            }
        }
        if (root.left != null) {
            root.left = sufficientSubset(root.left, limit);

        }
        if (root.right != null) {
            root.right = sufficientSubset(root.right, limit);
        }
        // 如果儿子都被删除，就删 root，否则不删 root
        return root.left == null && root.right == null ? null : root;
    }
}
