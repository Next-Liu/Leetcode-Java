package traceback;

import java.util.ArrayList;
import java.util.List;

public class Solution_2698punishmentNumber {
//    输入：n = 10
//    输出：182
//    解释：总共有 3 个整数 i 满足要求：
//            - 1 ，因为 1 * 1 = 1
//            - 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
//            - 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
//    因此，10 的惩罚数为 1 + 81 + 100 = 182

    //    输入：n = 37
//    输出：1478
//    解释：总共有 4 个整数 i 满足要求：
//            - 1 ，因为 1 * 1 = 1
//            - 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
//            - 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
//            - 36 ，因为 36 * 36 = 1296 ，且 1296 可以分割成 1 + 29 + 6 。
//    因此，37 的惩罚数为 1 + 81 + 100 + 1296 = 1478
    boolean res = false;

    public boolean judge(int num, List<String> list) {
        int sum = 0;
        if (list.size()==1 && num !=1){
            return false;
        }
        for (String s : list) {
            sum += Integer.parseInt(s);
        }
        return sum == num;
    }

    public void dfs(int start, String num, List<String> path) {
        if (start == num.length()) {
            if (judge(Integer.parseInt(num), path)) {
                res = true;
            }
            return;
        }
        for (int j = start; j < num.length(); j++) {
            String s = num.substring(start, j + 1);
            path.add(s);
            dfs(j + 1, num, path);
            path.remove(path.size() - 1);
        }
    }

    public int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            String num = String.valueOf((i+1) * (i+1));
            dfs(0, num, new ArrayList<>());
            if (res) {
                sum += (i+1) * (i+1);
            }
            res = false;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution_2698punishmentNumber ss = new Solution_2698punishmentNumber();
        int i = ss.punishmentNumber(10);
    }
}
