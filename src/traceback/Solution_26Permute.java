package traceback;

import java.util.*;

public class Solution_26Permute {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = null;
    private List<Boolean> choose = null;
    int n;

    public void dfs(int i, List<Boolean> choose,int[] nums) {
        if (i == n) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int j = 0; j < n; j++){
            if (!choose.get(j)) {
                choose.set(j, true);
                path.set(i, nums[j]);
                dfs(i + 1, choose, nums);
                choose.set(j, false); //恢复现场
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        path = Arrays.asList(new Integer[nums.length]);  // 初始化一个可变大小的路径列表
        choose = Arrays.asList(new Boolean[nums.length]);
        for (int i = 0; i < choose.size(); i++){
            choose.set(i, false);
        }

        // 调用递归函数进行全排列生成
        dfs(0, choose,nums);

        return ans;
    }
    public static void main(String[] args) {
        Solution_26Permute solution_26Permute = new Solution_26Permute();
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = solution_26Permute.permute(nums);
        System.out.println("lists = " + lists);
    }
}
