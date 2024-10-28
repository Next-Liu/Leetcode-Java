package array;

public class Solution_11 {
    public int maxArea(int[] height) {
        int length = height.length;
        int left = 0;
        int right = length - 1;
        int area = 0;
        while (left < right) {
            int tempArea = Math.min(height[left], height[right]) * (right - left);
            area = Math.max(area, tempArea);
            if (height[left] < height[right]) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        Solution_11 solution_11 = new Solution_11();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(solution_11.maxArea(height));
    }
}
