package array;

public class Solution_239maxSlidWindow {
    public int getMax(int[] nums,int left,int right){
        int max= Integer.MIN_VALUE;
        while(left<=right){
            max = Math.max(nums[left],max);
            left++;
        }
        return max;

    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int length = nums.length;
        int[] ans = new int[length-k+1];
        for(int i=0;i<=(length-k);i++){
            if(i==0){
                max = getMax(nums,i,i+k-1);
                ans[i] = max;
                continue;
            }
            else{
                int temp = nums[i+k-1];
                if(temp>max){
                    nums[i] = temp;
                }
                else{
                    nums[i] = max;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution_239maxSlidWindow s = new Solution_239maxSlidWindow();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ans = s.maxSlidingWindow(nums,k);
    }
}
