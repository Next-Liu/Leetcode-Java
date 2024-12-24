package traceback;

import java.util.ArrayList;
import java.util.List;

public class Solution_131HuiWenPartition {
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        int length = s.length();
        dfs(0, length, s);
        return ans;
    }

    public boolean check(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            } else {
                start += 1;
                end -= 1;
            }
        }
        return true;
    }

    /**
     *
     * @param i
     * @param length
     * @param s
     */
    public void dfs(int i, int length, String s) {
        if (i == length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        //枚举j作为子串的结束位置
        for (int j = i; j < length; j++) {
            String ss = s.substring(i, j + 1);
            if (check(ss)) {
                path.add(ss);
                dfs(j + 1, length, s);
                path.remove(path.size() - 1);
            }
        }
    }
}
