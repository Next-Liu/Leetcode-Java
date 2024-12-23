package traceback;

import java.util.ArrayList;
import java.util.List;

public class Solution_494TargetSum {
    public void dfs(int total, int[] nums, int target, int[] res, int i) {
        // 如果总和等于目标且已遍历完所有数字
        if (total == target && i == nums.length) {
            res[0] += 1; // 使用数组来传递和修改结果
            return;
        }

        // 如果已遍历完所有数字，但总和不等于目标，返回
        if (i == nums.length) {
            return;
        }

        // 递归处理加上当前数字的情况
        dfs(total + nums[i], nums, target, res, i + 1);

        // 递归处理减去当前数字的情况
        dfs(total - nums[i], nums, target, res, i + 1);
    }
    public int findTargetSumWays(int[] nums, int target) {
        int[] res = new int[1]; // 使用数组来存储结果，因为整数是不可变的
        dfs(0, nums, target, res, 0);
        return res[0];
    }

    public static void main(String[] args) {
        Solution_494TargetSum ss = new Solution_494TargetSum();
        int[] nums = {1, 1, 1};
        int target = 3;
        ss.findTargetSumWays(nums, target);
    }
}
