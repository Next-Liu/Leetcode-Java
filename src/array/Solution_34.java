package array;

import java.util.Arrays;
import java.util.Scanner;


public class Solution_34 {
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int[] searchRange(int[] nums, int target) {
        int start = binarySearch(nums, target);
        if (nums.length == start || nums[start] != target) {
            return new int[]{-1, -1};
        }
        int end = binarySearch(nums, target + 1) - 1;
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        Solution_34 solution_34 = new Solution_34();
        int[] result = solution_34.searchRange(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
