package traceback;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0
 * @auther 刘庆延
 * @email 2291572118@qq.com
 */
public class Solution_491 {
    LinkedList<Integer> temp = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();

    public void traceback(int[] nums, int startIndex) {
        if (temp.size() > 1) {
            result.add(new ArrayList<>(temp));
        }
        HashSet<Integer> hs = new HashSet<>();  // 用于去重
        for (int i = startIndex; i < nums.length; i++) {
            if (temp.size() > 0 && temp.getLast() > nums[i] || hs.contains(nums[i])) {
                continue;
            }
            hs.add(nums[i]);
            temp.add(nums[i]);
            traceback(nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        traceback(nums, 0);
        return result;
    }

    public static void main(String[] args) {
        Solution_491 s = new Solution_491();  
        int[] nums = {4, 6, 7, 7};
        List<List<Integer>> subsequences = s.findSubsequences(nums);
        System.out.println(subsequences);
    }
}
