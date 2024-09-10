package traceback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0
 * @auther 刘庆延
 * @email 2291572118@qq.com
 */
public class Solution_216 {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();

    public void traceback(int n, int k, int startIndex, int sum) {
        if (sum > n) {
            return;
        }
        if (path.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int j = startIndex; j <= n - (k - path.size()) + 1; j++) {
            path.add(j);
            sum += j;
            traceback(n, k, j + 1, sum);
            path.removeLast();
            sum -= j;
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        traceback(n, k, 1,0);
        return result;
    }

    public static void main(String[] args) {
        Solution_216 s = new Solution_216();
        List<List<Integer>> lists = s.combinationSum3(9, 45);
        System.out.println("lists:" + lists);
    }
}
