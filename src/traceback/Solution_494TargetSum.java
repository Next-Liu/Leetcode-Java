package traceback;

import java.util.ArrayList;
import java.util.List;

public class Solution_494TargetSum {
    public void dfs(int total, int element, int res, int target) {
        if (total == target) {
            res+=1;
            return;
        }
        dfs(total+element,);
    }

    public int findTargetSumWays(int[] nums, int target) {
        List<Integer> path = new ArrayList<>();
    }
}
