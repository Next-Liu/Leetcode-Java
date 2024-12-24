package traceback;

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
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> ans = new ArrayList<>();

    public boolean check(List<Integer> list) {
        if (list.size() < 3) {
            return false;
        }
        for (int i = 0; i < list.size() - 2; i++) {
            if (list.get(i) + list.get(i + 1) != list.get(i+2)) {
                return false;
            }
        }
        return true;


    }

    public void dfs(String num, int start) {
        if (start == num.length()) {
            if (check(path)){
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        for (int j = start; j < num.length(); j++) {
            int ele = Integer.parseInt(num.substring(start, j + 1));
            path.add(ele);
            dfs(num, j + 1);
            path.remove(path.size() - 1);
        }
    }

    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        dfs(num, 0);
        return ans.size() > 0;
    }

    public static void main(String[] args) {
        Solution_306isAdditiveNumber ss = new Solution_306isAdditiveNumber();
        boolean additiveNumber = ss.isAdditiveNumber("112358");
    }
}
