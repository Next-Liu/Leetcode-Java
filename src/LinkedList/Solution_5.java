package LinkedList;

/**
 * @version 1.0
 * @auther 刘庆延
 * @email 2291572118@qq.com
 */
public class Solution_5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len]; // 每个位置代表s[i]到s[j]之间是否是回文
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] s_array = s.toCharArray();
        for (int L = 2; L <= len; L++) {  // L代表回文子串所有可能得长度
            for (int i = 0; i < len; i++) {  // 定义左边界
                int j = i + L - 1; // 定义右边界
                if (j >= len) {
                    break;
                }
                if (s_array[i] != s_array[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];  //若i到j的位置是回文，则i+1到j-1也是回文
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {  //记录最大回文长度和起始位置
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        Solution_5 solution = new Solution_5();
        String s = "babad";
        String result = solution.longestPalindrome(s);
        System.out.println(result);
    }
}
