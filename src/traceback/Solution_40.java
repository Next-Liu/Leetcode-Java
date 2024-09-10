package traceback;

import java.util.*;

/**
 * @version 1.0
 * @auther 刘庆延
 * @email 2291572118@qq.com
 */
public class Solution_40 {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    public void traceback(int[] candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > startIndex && candidates[i] == candidates[i-1]){
                continue;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            traceback(candidates, target, sum, i+1);
            sum -= path.get(path.size() - 1);
            path.removeLast();
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        traceback(candidates, target, 0, 0);
        return result;
    }
    public static void main(String[] args) {
        Solution_40 solution_40 = new Solution_40();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> lists = solution_40.combinationSum2(candidates, target);
        System.out.println("lists = " + lists);
    }
}
