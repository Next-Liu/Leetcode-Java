package traceback;

import java.util.ArrayList;
import java.util.List;

public class Solution_306ChooseOrNot {
    char[] numchar;
    boolean res;
    List<String> path;
    String num;

    public int toInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = sum * 10 + (s.charAt(i) - '0');
        }
        return sum;
    }

    // 判断当前路径是否符合加法数条件
    public boolean judge() {
        if (path.size() < 3) {
            return false;
        }
        for (int i = 0; i < path.size() - 2; i++) {
            if (toInt(path.get(i)) + toInt(path.get(i + 1)) != toInt(path.get(i + 2))) {
                return false;
            }
        }
        return true;
    }

    // 使用 DFS 进行回溯，尝试所有分割方案
    public void dfs(int start) {
        // 边界条件：当已经找到了符合条件的加法数时，返回
        if (res) {
            return;
        }
        // 如果已经遍历到字符串的末尾，检查当前路径是否符合加法数
        if (start == num.length()) {
            if (judge()) {
                res = true;
            }
            return;
        }

        // 遍历所有可能的分割点
        for (int end = start + 1; end <= num.length(); end++) {
            String subStr = num.substring(start, end);

            // 处理前导零的情况，只有 "0" 是合法的，不允许 "00" 或 "000" 等
            if (subStr.length() > 1 && subStr.charAt(0) == '0') {
                continue;
            }

            // 添加当前数字并递归
            path.add(subStr);
            dfs(end);  // 递归，开始处理下一个部分
            path.remove(path.size() - 1);  // 回溯，移除最后一个数字
        }
    }

    // 主函数，判断是否为加法数
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3)
            return false;

        this.num = num;
        numchar = num.toCharArray();
        path = new ArrayList<>();
        res = false;

        // 开始从第一个字符递归分割
        dfs(0);

        return res;
    }
}
