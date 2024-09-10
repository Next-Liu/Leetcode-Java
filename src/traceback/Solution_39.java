package traceback;

import java.util.*;

/**
 * @version 1.0
 * @auther 刘庆延
 * @email 2291572118@qq.com
 */
public class Solution_39 {
    LinkedList<Integer> temp = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();

    public void traceback(int[] candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            temp.add(candidates[i]);
            traceback(candidates, target, sum, i);
            sum -= temp.get(temp.size() - 1);
            temp.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        traceback(candidates, target, 0, 0);
        return result;
    }

    public static void main(String[] args) {
        Solution_39 solution_39 = new Solution_39();
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> lists = solution_39.combinationSum(candidates, target);
        System.out.println("lists = " + lists);
    }
}
