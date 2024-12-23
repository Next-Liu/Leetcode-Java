package traceback;

import java.util.ArrayList;
import java.util.List;

public class Solution_113RoadTotal {
    public boolean check(List<Integer> path, int targetSum) {
        int sum = 0;
        for (int i : path) {
            sum += i;
        }
        return sum == targetSum;
    }

    public void dfs(TreeNode root, List<List<Integer>> ans, List<Integer> path, int targetSum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && check(path, targetSum)) {
            ans.add(new ArrayList<>(path));
        } else {
            dfs(root.left, ans, path, targetSum);
            dfs(root.right, ans, path, targetSum);
        }
        path.remove(path.size() - 1);

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root,ans,path,targetSum);
        return ans;
    }
}
