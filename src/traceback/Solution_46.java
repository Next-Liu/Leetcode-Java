package traceback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @version 1.0
 * @auther 刘庆延
 * @email 2291572118@qq.com
 */
public class Solution_46 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        used = new boolean[nums.length];
        backTracking(nums);
        return result;
    }

    public void backTracking(int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backTracking(nums);
            path.removeLast();
            used[i] = false;
        }
    }


    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c'};
        // 将字符数组转换为字符串
        String str = String.valueOf(chars);
        System.out.println(str);
    }
}
