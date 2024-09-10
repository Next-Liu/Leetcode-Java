package DynamicPlanning;

/**
 * @version 1.0
 * @auther 刘庆延
 * @email 2291572118@qq.com
 */
public class Solution_62 {
    public int Factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * Factorial(n - 1);
        }
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 初始化 dp[i][0] = 1, dp[0][j] = 1
        // 从(0,0)到(0,1)的路径数量为1,从(0,1)到(0,2)的路径数量为1,从(0,2)到(0,3)的路径数量为1,...故dp[0][j] = 1;
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        for (int j = 0; j < n; j++)
            dp[0][j] = 1;
        //dp[i][j]代表从(0,0)到(i,j)的路径数量
        //dp[i][j]，只能有两个方向来推导出来，即dp[i - 1][j] 和 dp[i][j - 1]。
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution_62 solution62 = new Solution_62();
        System.out.println(solution62.uniquePaths(3, 7));
    }
}
