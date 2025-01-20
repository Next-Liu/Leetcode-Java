package DynamicPlanning;

import java.util.Arrays;

public class Solution_377combinationSum4 {
    /**
     * 本质是爬楼梯问题
     */
    int n;
    int[] memo;

    public int dfs(int[] nums, int i) {
        if (i == 0) {
            return 1;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int res = 0;
        for (int ele : nums) {
            if (ele <= i) {
                res += dfs(nums, i - ele);
            }
        }
        return memo[i] = res;


    }

    public int combinationSum4(int[] nums, int target) {
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return dfs(nums, target);

    }
}
