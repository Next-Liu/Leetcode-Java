package Tree;

public class Solution_129 {
    int ans;

    public void dfs(TreeNode root, int x) {
        if (root == null) {
            return;
        }
        x = x * 10 + root.val;
        if (root.left == root.right) {
            ans += x;
        }
        dfs(root.left, x);
        dfs(root.right, x);
    }

    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return ans;
    }

    public static void main(String[] args) {
        Solution_129 solution129 = new Solution_129();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(solution129.sumNumbers(root));
    }
}