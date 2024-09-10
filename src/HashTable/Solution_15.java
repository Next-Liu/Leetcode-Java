package HashTable;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) { //排序后如果第一个元素大于0，则不可能
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }
                else if(nums[i] + nums[left] + nums[right] < 0){
                    left++;
                }
                else{
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //去重后两个元素
                    while (left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Solution_15 solution15 = new Solution_15();
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = solution15.threeSum(nums);
        System.out.println(lists);
    }
}
