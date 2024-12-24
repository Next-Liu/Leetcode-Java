package traceback;

import java.util.ArrayList;
import java.util.List;

public class Solution_93RestoreIp {
    private List<String> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public void dfs(int i, String s) {
        if (i == s.length() && path.size() == 4) {
            StringBuilder ss = new StringBuilder();
            for (int x : path) {
                ss.append(x).append(".");
            }
            // 去掉最后一个多余的点
            ans.add(ss.substring(0, ss.length() - 1));
        }
        for (int j = i; j < s.length(); j++) {
            int num = Integer.parseInt(s.substring(i, j + 1));
            if (num > 255 || path.size() == 4 || (j > i && s.charAt(i) == '0') || j - i > 4) {
                return;
            }
            path.add(num);
            dfs(j + 1, s);
            path.remove(path.size() - 1);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        dfs(0, s);
        return ans;
    }

    public static void main(String[] args) {
        Solution_93RestoreIp ss = new Solution_93RestoreIp();
        List<String> strings = ss.restoreIpAddresses("25525511135");
    }


}
