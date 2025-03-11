package DynamicPlanning;

public class Solution_2266CountTexts {
    /**
     * 2:a b c
     * 3:d e f
     * 4:g h i
     * 5:j k l
     * 6:m n o
     * 7:p q r s
     * 8:t u v
     * 9:w x y z
     * 为了 打出 一个字母，Alice 需要 按 对应字母 i 次，i 是该字母在这个按键上所处的位置。
     * 比方说，为了按出字母 's' ，Alice 需要按 '7' 四次。类似的， Alice 需要按 '5' 两次得到字母  'k'(0和1不使用)。
     * 给你一个字符串 pressedKeys ，表示 Bob 收到的字符串，请你返回 Alice 总共可能发出多少种文字信息 。
     * 由于答案可能很大，将它对 10^9 + 7 取余 后返回。
     * <p>
     * 输入：pressedKeys = "22233"
     * 输出：8
     * 解释：
     * Alice 可能发出的文字信息包括：
     * "aaadd", "abdd", "badd", "cdd", "aaae", "abe", "bae" 和 "ce" 。
     */
    private static final int MOD = 1_000_000_007;//10^9+7
    private static final int MX = 100_001; //10^5+1
    private static final long[] f = new long[MX];
    private static final long[] g = new long[MX];

    public int countTexts(String pressedKeys) {
        f[0] = g[0] = 1;
        f[1] = g[1] = 1;
        f[2] = g[2] = 2;
        f[3] = g[3] = 4;
        for (int i = 4; i < MX; i++) {
            f[i] = (f[i - 1] + f[i - 2] + f[i - 3]) % MOD;
            g[i] = (g[i - 1] + g[i - 2] + g[i - 3] + g[i - 4]) % MOD;
        }
        long ans = 1;
        int cnt = 0;
        for (int i = 0; i < pressedKeys.length(); i++) {
            char c = pressedKeys.charAt(i);
            cnt++;
            if (i == pressedKeys.length() - 1 || pressedKeys.charAt(i + 1) != c) {
                ans = ans * (c != '7' && c != '9' ? f[cnt] : g[cnt]) % MOD;
                cnt = 0;
            }
        }
        return (int)ans;
    }
}
