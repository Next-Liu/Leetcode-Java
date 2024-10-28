package DynamicPlanning;

public class Solution_343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                int temp_max = Math.max(j * (i - j), j * dp[i - j]);
                dp[i] = Math.max(temp_max, dp[i]);
            }
        }
        return dp[n];
    }
}
