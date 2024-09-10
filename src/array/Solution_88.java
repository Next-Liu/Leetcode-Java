package array;

/**
 * @version 1.0
 * @auther 刘庆延
 * @email 2291572118@qq.com
 */
public class Solution_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sorted = new int[m + n];
        int p1 = 0, p2 = 0;
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] <= nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int x = 0; x < m + n; x++) {
            nums1[x] = sorted[x];
        }
    }
}
