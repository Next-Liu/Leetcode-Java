package DynamicPlanning;

public class Solution_494 {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        //细节1
        if (Math.abs(target) > total) {
            return 0;
        }
        //细节2 target可能为0
        if ((total + target) % 2 == 1) {
            return 0;
        }
        int left = (total + target) / 2;
        int[][] dp = new int[nums.length][left + 1];
        //初始化数组
        if (nums[0] <= left) {
            dp[0][nums[0]] = 1;
        }
        int nums_zero = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                nums_zero++;
            }
            dp[j][0] = (int) Math.pow(2.0, nums_zero);
        }
        for (int k = 1; k < nums.length; k++) {
            for (int q = 1; q <= left; q++) {
                if (q < nums[k]) {
                    dp[k][q] = dp[k - 1][q];
                } else {
                    dp[k][q] = dp[k - 1][q] + dp[k - 1][q - nums[k]];
                }
            }
        }
        return dp[nums.length - 1][left];
    }
}
