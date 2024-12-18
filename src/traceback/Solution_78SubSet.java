package traceback;

import java.util.ArrayList;
import java.util.List;

public class Solution_78SubSet {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums.length, nums);
        return ans;
    }

    public void dfs(int i, int length, int[] nums) {
        if (i == length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        //不选nums[i]直接递归
        dfs(i + 1, length, nums);
        path.add(nums[i]);
        dfs(i + 1, length, nums);
        path.remove(path.size() - 1);
    }
}
