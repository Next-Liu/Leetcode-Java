package traceback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_784LetterCasePermutationCheckChar {
//    示例 1：
//    输入：s = "a1b2"
//    输出：["a1b2", "a1B2", "A1b2", "A1B2"]

    //    示例 2:
//    输入: s = "3z4"
//    输出: ["3z4","3Z4"]
//    a:97 A:65
    public void dfs(char[] charArray, List<String> ans, int index) {
        if (index == charArray.length) {
            ans.add(new String(charArray));
            return;
        }
        dfs(charArray, ans, index + 1);
        if (Character.isLetter(charArray[index])) {
            charArray[index] ^= 1 << 5;
            dfs(charArray, ans, index + 1);
        }
    }

    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        char[] charArray = s.toCharArray();
        dfs(charArray,ans,0);
        return ans;
    }
}
