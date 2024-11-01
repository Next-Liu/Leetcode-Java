package array;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_2300 {
    private int binarySearch(int[] nums, long target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;  //返回的是nums中第一个大于等于target的数的下标，如果没找到，就是nums.length
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            long target = (success + spells[i] - 1) / spells[i];
            if (target <= potions[potions.length - 1]) {
                spells[i] = potions.length - binarySearch(potions, target);
            } else {
                spells[i] = 0;
            }
        }
        return spells;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] spells = new int[n];
        for (int i = 0; i < n; i++) {
            spells[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] potions = new int[m];
        for (int i = 0; i < m; i++) {
            potions[i] = sc.nextInt();
        }
        long success = sc.nextLong();
        Solution_2300 solution_2300 = new Solution_2300();
        int[] result = solution_2300.successfulPairs(spells, potions, success);
        System.out.println(Arrays.toString(result));
    }
}
