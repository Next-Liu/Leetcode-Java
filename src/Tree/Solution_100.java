package Tree;

public class Solution_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p== q;  //其中一个为空，另一个不为空返回false 否则返回true
        }
        return p.val==q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Solution_100 s = new Solution_100();
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(1);
        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(1);
        tree2.right = new TreeNode(2);
        boolean sameTree = s.isSameTree(tree1, tree2);
    }
}
