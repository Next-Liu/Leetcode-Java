package LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_15threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            //剪枝
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int j = i + 1;
            int k = length - 1;
            while (j < k) {
                int total = nums[j] + nums[k];
                if (target > total) {
                    j++;
                }else if(target < total){
                    k--;
                }else{
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j+=1;
                    k-=1;
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
}
