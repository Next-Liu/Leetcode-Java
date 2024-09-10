package traceback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @auther 刘庆延
 * @email 2291572118@qq.com
 */
public class Solution_17 {
    List<String> result = new ArrayList();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String[] dicts = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        traceback(digits, dicts, 0);
        return result;
    }

    StringBuilder temp = new StringBuilder();

    public void traceback(String digits, String[] numString, int num) {
        if (num == digits.length()) {
            result.add(temp.toString());
            return;
        }
        String cur = numString[digits.charAt(num) - '0'];//当前位置数字代表的字符串
        for (int i = 0; i < cur.length(); i++) {
            temp.append(cur.charAt(i));
            traceback(digits, numString, num + 1);
            temp.deleteCharAt(temp.length()-1);
        }
    }

    public static void main(String[] args) {
        Solution_17 s = new Solution_17();
        List<String> strings = s.letterCombinations("23");
        System.out.println(strings);
    }
}
