package traceback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @version 1.0
 * @auther 刘庆延
 * @email 2291572118@qq.com
 */
public class Solution_131 {
    public boolean check(String s, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            if (s.charAt(startIndex) != s.charAt(endIndex)) {
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }

    LinkedList<String> temp = new LinkedList<>();
    List<List<String>> result = new ArrayList<>();

    public void traceback(String s, int startIndex) {
        if (startIndex == s.length()) {  // 递归终止条件
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (check(s,startIndex,i)){
                String str = s.substring(startIndex,i+1);
                temp.addLast(str);
            }else{
                continue;
            }
            traceback(s,i+1);
            temp.removeLast();
        }
    }

    public List<List<String>> partition(String s) {
        traceback(s,0);
        return result;
    }

    public static void main(String[] args) {
        Solution_131 solution = new Solution_131();
        List<List<String>> result = solution.partition("aab");
        for (List<String> l:result){
            System.out.println(l);
        }

    }
}
