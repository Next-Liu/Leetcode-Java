package traceback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution_17LetterCombination {
    private static final String[] MAPPING = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ans = new ArrayList<>();
    private char[] digits;
    private char[] path;

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0){
            return new ArrayList<>();
        }
        this.digits = digits.toCharArray();
        path = new char[n];
        dfs(0);
        return ans;

    }

    private void dfs(int i) {
        if (i == digits.length) {
            ans.add(new String(path));
            return;
        }
        for (char c:MAPPING[digits[i]-'0'].toCharArray()){
            path[i] = c;  //直接覆盖
            dfs(i+1);
        }
    }
}
