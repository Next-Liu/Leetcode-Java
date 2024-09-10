package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class Solution_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0){
            int[] res = new int[0];
            return res;
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> reset = new HashSet<>();
        for (int i:nums1){
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                reset.add(i);
            }
        }
        int[] arr = new int[reset.size()];
        int j = 0;
        for(int i:reset){
            arr[j++] = i;
        }
        return arr;
    }
}
