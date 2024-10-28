package array;

public class Solution_42 {
    public int trap(int[] height) {
        int length = height.length;
        // 每个柱子上能装的雨水 = min(左边柱子最大高度，右边柱子最大高度) - 当前柱子高度
        int[] preMax = new int[length];
        preMax[0] = height[0];
        int[] sufferMax = new int[length];
        if (length > 2) {
            for (int i = 1; i < length; i++) {
                preMax[i] = Math.max(preMax[i - 1], height[i]);
            }
        }
        sufferMax[length - 1] = height[length - 1];
        if (length > 2) {
            for (int j = length - 2; j > -1; j--) {
                sufferMax[j] = Math.max(sufferMax[j + 1], height[j]);
            }
        }
        int trap = 0;
        for (int k = 0; k < length; k++) {
            trap += Math.min(preMax[k],sufferMax[k])-height[k];
        }
        return trap;
    }

    public static void main(String[] args) {
        Solution_42 s = new Solution_42();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(s.trap(height));
        int [] height2 = {4,2,0,3,2,5};
        System.out.println(s.trap(height2));
    }
}
