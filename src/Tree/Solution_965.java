package Tree;

public class Solution_965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null){
            return true;
        }
        if (root.left!=null){
            if (root.left.val != root.val || !isUnivalTree(root.left)){
                return false;
            }
        }
        if (root.right!=null){
            if (root.right.val != root.val || !isUnivalTree(root.right)){
                return false;
            }
        }
        return true;
    }
}
