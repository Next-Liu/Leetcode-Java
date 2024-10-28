package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            // 剪枝
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = length - 1;
            int target = -nums[i];
            while (j < k) {
                int total = nums[j] + nums[k];
                if (total < target) {
                    j += 1;
                } else if (total > target) {
                    k -= 1;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j += 1;
                    k -= 1;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j += 1;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k -= 1;
                    }
                }
            }

        }
        return res;
    }


    public static void main(String[] args) {
        Solution_15 solution_15 = new Solution_15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = solution_15.threeSum(nums);
        System.out.println(lists);
    }
}
