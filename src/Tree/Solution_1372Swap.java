package Tree;

public class Solution_1372Swap {
    /**
     * 选择二叉树中 任意 节点和一个方向（左或者右）。
     * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
     * 改变前进方向：左变右或者右变左。
     *
     * @param root
     * @return
     */
    private int ans = -1;

    public int longestZigZag(TreeNode root) {
        dfs(root,0,0);
        return ans;
    }

    /**
     * flag=0 :父节点为根节点，加一
     * flag=1：父节点为左孩子结点
     * flag=2：父节点为右孩子结点
     *
     * @param root
     * @param flag
     * @param tempLength
     */

    public void dfs(TreeNode root, int flag, int tempLength) {
        if (root == null) {
            return;
        }
        if (tempLength > ans) {
            ans = tempLength;
        }
        if (flag == 0) {
            dfs(root.left, 1, tempLength + 1);
            dfs(root.right, 2, tempLength + 1);
        }
        if (flag == 1) {
            dfs(root.left, 1, 1);
            dfs(root.right, 2, tempLength + 1);
        }
        if (flag == 2) {
            dfs(root.left, 1, tempLength + 1);
            dfs(root.right, 2, 1);
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        Solution_1372Swap s = new Solution_1372Swap();
    }
}
