package traceback;

import java.util.ArrayList;
import java.util.List;

public class Solution_78SubSet {
    /**
     * 子集型回溯：
     *    每个元素选/不选
     * [1,2,3]为例：
     *  子集生成顺序为：[],[3],[2],[2,3],[1],[1,3],[1,2],[1,2,3]
     * */
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
