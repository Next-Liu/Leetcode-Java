package DynamicPlanning;

import java.util.Arrays;

public class Solution_746minCostClimbingStairs {
    /**
     * cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
     * 可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。计算并返回达到楼梯顶部的最低花费。
     *
     * @param cost
     * @return
     */
    /**
     * 如果最后一步爬了 1 个台阶，那么我们得先爬到 i−1，要解决的问题缩小成：从 0 或 1 爬到 i−1 的最小花费。把这个最小花费加上 cost[i−1]，就得到了 dfs(i)，即 dfs(i)=dfs(i−1)+cost[i−1]。
     * 如果最后一步爬了 2 个台阶，那么我们得先爬到 i−2，要解决的问题缩小成：从 0 或 1 爬到 i−2 的最小花费。把这个最小花费加上 cost[i−2]，就得到了 dfs(i)，即 dfs(i)=dfs(i−2)+cost[i−2]。
     *
     * @param cost
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1); // -1 表示没有计算过
        return dfs(n, memo, cost);
    }

    private int dfs(int i, int[] memo, int[] cost) {
        if (i <= 1) { // 递归边界
            return 0;
        }
        if (memo[i] != -1) { // 之前计算过
            return memo[i];
        }
        int res1 = dfs(i - 1, memo, cost) + cost[i - 1];
        int res2 = dfs(i - 2, memo, cost) + cost[i - 2];
        return memo[i] = Math.min(res1, res2); // 记忆化
    }
}
