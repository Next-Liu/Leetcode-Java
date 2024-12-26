package traceback;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Solution_306isAdditiveNumber {
    /**
     * 输入："112358"
     * 输出：true
     * 解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
     * <p>
     * 输入："199100199"
     * 输出：true
     * 解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
     */
    private List<BigInteger> path = new ArrayList<>();  // 使用 BigInteger 类型存储数字
    private List<List<BigInteger>> ans = new ArrayList<>();

    // 检查是否符合加法数条件
    public boolean check(List<BigInteger> list) {
        // 加法数必须至少有 3 个数
        if (list.size() < 3) {
            return false;
        }
        // 判断每一组三个数字是否符合加法数的定义
        for (int i = 2; i < list.size(); i++) {
            if (!list.get(i).equals(list.get(i - 1).add(list.get(i - 2)))) {
                return false;
            }
        }
        return true;
    }

    // 使用 DFS 进行回溯
    public void dfs(String num, int start) {
        // 如果已遍历到字符串的结尾，检查是否是加法数
        if (start == num.length()) {
            if (check(path)) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }

        // 遍历所有可能的分割点
        for (int end = start + 1; end <= num.length(); end++) {
            // 获取当前数字
            String subStr = num.substring(start, end);

            // 处理前导零的情况，数字不能以零开头（除非数字本身就是 0）
            if (subStr.length() > 1 && subStr.charAt(0) == '0') {
                continue;
            }

            // 转换为 BigInteger 类型的整数
            BigInteger numValue = new BigInteger(subStr);
            path.add(numValue);

            // 递归处理下一个部分
            dfs(num, end);

            // 回溯，移除最后一个添加的数字
            path.remove(path.size() - 1);
        }
    }

    // 主函数，判断是否为加法数
    public boolean isAdditiveNumber(String num) {
        // 数字长度至少要为 3
        if (num.length() < 3) {
            return false;
        }

        // 调用 DFS 函数进行回溯
        dfs(num, 0);

        // 如果找到了符合条件的分割方式，则返回 true
        return ans.size() > 0;
    }

    public static void main(String[] args) {
        Solution_306isAdditiveNumber ss = new Solution_306isAdditiveNumber();
        boolean additiveNumber = ss.isAdditiveNumber("1999999999999999910000000000000000");

        System.out.println("Is Additive Number: " + additiveNumber); // 输出结果
    }
}
