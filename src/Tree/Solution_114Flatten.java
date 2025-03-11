package Tree;

import java.util.ArrayList;
import java.util.List;

public class Solution_114Flatten {
    List<Integer> preOrder = new ArrayList<>();
    public void PreOrder(TreeNode root){
        if(root==null){
            return;
        }
        preOrder.add(root.val);
        PreOrder(root.left);
        PreOrder(root.right);
    }
    public void flatten(TreeNode root) {
        PreOrder(root);
        if(preOrder.size()==0||preOrder.size()==1){
            return;
        }
        TreeNode newRoot = new TreeNode(-1);
        TreeNode p = new TreeNode(preOrder.get(0));
        newRoot.right = p;
        for(int i = 1;i<preOrder.size();i++){
            TreeNode temp = new TreeNode(preOrder.get(i));
            p.right = temp;
            p = p.right;
        }
        root = newRoot.right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        Solution_114Flatten solution114Flatten = new Solution_114Flatten();
        solution114Flatten.flatten(root);
    }
}
