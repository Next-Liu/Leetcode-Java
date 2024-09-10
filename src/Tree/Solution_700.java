package Tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * @version 1.0
 * @auther 刘庆延
 * @email 2291572118@qq.com
 */
public class Solution_700 {
    public TreeNode traversal(TreeNode root, int val){
        if (root!=null || root.val == val){
            return root;
        }
        if (root.left!=null){
            traversal(root.left,val);
        }
        if (root.right!=null){
            return traversal(root.right,val);
        }
        return null;
    }
    public TreeNode searchBST(TreeNode root, int val) {
        return traversal(root,val);
    }
}
