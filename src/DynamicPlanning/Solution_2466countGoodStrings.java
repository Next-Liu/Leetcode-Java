package DynamicPlanning;

public class Solution_2466countGoodStrings {
    /**
     * 给你整数 zero ，one ，low 和 high ，我们从空字符串开始构造一个字符串，每一步执行下面操作中的一种：
     * 将 '0' 在字符串末尾添加 zero  次。
     * 将 '1' 在字符串末尾添加 one 次。
     * 以上操作可以执行任意次。
     * 如果通过以上过程得到一个 长度 在 low 和 high 之间（包含上下边界）的字符串，那么这个字符串我们称为 好 字符串。
     */
    public int countGoodStrings(int low, int high, int zero, int one) {
        //dp[i] 表示长度为 i 的字符串的构造方式总数。
        int[] dp = new int[high + 1];
        dp[0] = 1; // 空字符串有一种构造方式(不用添加任何字符)
        //如果 i >= zero，则可以从长度为 i - zero 的字符串添加 zero 个 '0'，因此 dp[i] += dp[i - zero]。
        //如果 i >= one，则可以从长度为 i - one 的字符串添加 one 个 '1'，因此 dp[i] += dp[i - one]。
        for (int i = 1; i <= high; i++) {
            if (i >= zero) {
                dp[i] = (int) ((dp[i] + dp[i - zero]) % (Math.pow(10, 9) + 7));
            }
            if (i >= one) {
                dp[i] = (int) ((dp[i] + dp[i - one]) % (Math.pow(10, 9) + 7));
            }
        }

        int total = 0;
        for (int i = low; i <= high; i++) {
            total = (total + dp[i]) % 1_000_000_007;
        }

        return total;
    }
}
