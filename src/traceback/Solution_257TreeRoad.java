package traceback;

import java.util.ArrayList;
import java.util.List;

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

public class Solution_257TreeRoad {
    private String buildPath(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
            if (i < path.size() - 1) {
                sb.append("->");
            }
        }
        return sb.toString();
    }

    private void dfs(TreeNode node, List<Integer> path, List<String> res) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        // If it's a leaf node, convert path to string and add to result list
        if (node.left == null && node.right == null) {
            res.add(buildPath(path));
        } else {
            // Otherwise, continue DFS on left and right subtrees
            dfs(node.left, path, res);
            dfs(node.right, path, res);
        }
        // Backtrack (remove the current node from the path)
        path.remove(path.size() - 1);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, path, ans);
        return ans;
    }
}
