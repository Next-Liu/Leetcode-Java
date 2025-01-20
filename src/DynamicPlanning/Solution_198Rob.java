package DynamicPlanning;

public class Solution_198Rob {
    /**
     * 偷的房间不能相邻
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     * 偷窃到的最高金额 = 1 + 3 = 4 。
     */
    int[] nums;
    int n;
    int[] caches;//用于记录，防止多余运算

    /**
     * dfs(i)表示从前i个房子打劫到的最大值
     */
    public int dfs(int i) {
        if (i < 0) {
            return 0;
        }
        if (caches[i] != -1) {
            return caches[i];
        }
        int res = Math.max(dfs(i - 1), dfs(i - 2) + nums[i]);
        caches[i] = res;
        return res;

    }

    public int rob(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        caches = new int[n];
        for (int i = 0; i < n; i++) {
            caches[i] = -1;
        }
        return dfs(n - 1);
    }

}
