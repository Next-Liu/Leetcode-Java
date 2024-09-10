package test;

/**
 * @version 1.0
 * @auther 刘庆延
 * @email 2291572118@qq.com
 */
public class Solution {
    //有一个整数数组0和非0，把0移到左边非0移到右边，同时保证非0在原数组的顺序
    public int[] answer(int[] arr, int length) {
        int[] new_arr = new int[length];
        int count_0 = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == 0) {
                count_0++;
            }
        }
        for (int j = 0; j < count_0; j++)
            new_arr[j] = 0;
        int z = 0;
        for (int k = 0; k < length; k++) {
            if (arr[k] != 0) {
                new_arr[count_0+z] = arr[k];
                z++;
            }
        }
        return new_arr;
    }
    public static void moveZeros(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int insertPos = 0;

        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {0,1,0,3,0,1,2};
        s.moveZeros(arr);
        for (int i:arr){
            System.out.println(i);
        }
    }
}
