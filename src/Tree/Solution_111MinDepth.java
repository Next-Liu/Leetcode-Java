package Tree;

public class Solution_111MinDepth {
    private int ans = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        dfs(root, 0);
        return root != null ? ans : 0;
    }

    private void dfs(TreeNode node, int cnt) {
        if (node == null) {
            return;
        }
        cnt++;
        if (node.left == node.right) { // node 是叶子
            ans = Math.min(ans, cnt);
            return;
        }
        dfs(node.left, cnt);
        dfs(node.right, cnt);
    }
//    如果 node 是空节点，由于没有节点，返回 0。
//    如果 node 没有右儿子，那么深度就是左子树的深度加一，即 dfs(node)=dfs(node.left)+1。
//    如果 node 没有左儿子，那么深度就是右子树的深度加一，即 dfs(node)=dfs(node.right)+1。
//    如果 node 左右儿子都有，那么分别递归计算左子树的深度，以及右子树的深度，二者取最小值再加一，即
//
//    public int minDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        if (root.right == null) {
//            return minDepth(root.left) + 1;
//        }
//        if (root.left == null) {
//            return minDepth(root.right) + 1;
//        }
//        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;

}
