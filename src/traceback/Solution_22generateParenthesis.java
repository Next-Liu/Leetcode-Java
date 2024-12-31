package traceback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_22generateParenthesis {
    int m;
    int n;
    private List<String> ans = new ArrayList<>();
    private char[] path;

    public void dfs(int i, int open) {
        if (i == m) {
            ans.add(new String(path));
            return;
        }
        if (open < n) {
            path[i] = '(';
            dfs(i + 1, open + 1);
        }
        if (i - open < open) {
            path[i] = ')';
            dfs(i + 1, open);
        }
    }

    public List<String> generateParenthesis(int n) {
        /**
         * 左括号个数：open
         * 需要选n个左括号，open<n可以选左括号
         * 右括号个数i-open，若右括号个数i-open<open则可以选右括号
         */
        this.n = n;
        this.m = 2 * n;
        path = new char[m];
        dfs(0, 0);
        return ans;
    }
}
