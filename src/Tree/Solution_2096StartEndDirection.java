package Tree;

import java.util.ArrayList;
import java.util.List;

public class Solution_2096StartEndDirection {
    List<Character> sc;
    List<Character> cd;
    List<List<Character>> ans;

    public TreeNode getCommonParent(TreeNode node, int startValue, int destValue) {
        if (node == null || node.val == startValue || node.val == destValue) {
            return node;
        }
        TreeNode left = getCommonParent(node.left, startValue, destValue);
        TreeNode right = getCommonParent(node.right, startValue, destValue);
        if (left != null && right != null) {
            return node;
        }
        if (left != null) {
            return left;
        }
        return right;
    }

    public void dfsStart(TreeNode common, int startValue) {
        if (common == null) {
            return;
        }
        if (common.val == startValue) {
            ans.add(new ArrayList<>(sc));
            return;
        }
        sc.add('U');   //代表找父节点操作
        dfsStart(common.left, startValue);
        sc.remove(sc.size() - 1);
        sc.add('U');
        dfsStart(common.right, startValue);
        sc.remove(sc.size() - 1);
    }

    public void dfsDest(TreeNode common, int destValue) {
        if (common == null) {
            return;
        }
        if (common.val == destValue) {
            ans.add(new ArrayList<>(cd));
            return;
        }
        cd.add('L');
        dfsDest(common.left, destValue);
        cd.remove(cd.size() - 1);
        cd.add('R');
        dfsDest(common.right, destValue);
        cd.remove(cd.size() - 1);
    }


    public String getDirections(TreeNode root, int startValue, int destValue) {
        /**
         * 'L' 表示从一个节点前往它的 左孩子 节点。
         * 'R' 表示从一个节点前往它的 右孩子 节点。
         * 'U' 表示从一个节点前往它的 父 节点。
         * 还需是最短路径
         * 找到startValue和destValue对应的最近公共父节点
         * 两条路径：startValue到父节点
         *         父节点到destValue
         */
        TreeNode commonNode = getCommonParent(root, startValue, destValue);
        sc = new ArrayList<>();//common to start 的路径
        cd = new ArrayList<>();//common to dest 的路径
        ans = new ArrayList<>();
        dfsStart(commonNode, startValue);
        dfsDest(commonNode, destValue);
        StringBuilder sb = new StringBuilder();
        for (List<Character> lc : ans) {
            for (Character c : lc) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node6;
        node2.right = node4;
        Solution_2096StartEndDirection ss = new Solution_2096StartEndDirection();
        ss.getDirections(root, 3, 4);
    }
}
