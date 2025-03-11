package array;

public class Solution_146SpiralArray {
    public int[] spiralArray(int[][] matrix) {
        //特判
        if(matrix == null ||matrix.length == 0){
            return new int[0];
        }

        //初始化
        int left = 0, top = 0;
        int right = matrix[0].length-1;
        int bottom = matrix.length - 1;
        int[] res = new int[(right+1)*(bottom+1)];
        int k = 0;

        //循环打印
        while(top <= bottom && left <= right){
            for(int i = left; i <= right; i++){ //从左到右
                res[k++] = matrix[top][i];
            }
            top ++;
            for(int i = top; i <= bottom; i++){ //从上到下
                res[k++] = matrix[i][right];
            }
            right --;
            for(int i = right; i >= left && top <= bottom; i--){    //从右到左
                res[k++] = matrix[bottom][i];
            }
            bottom --;
            for(int i = bottom; i >= top && left <= right; i--){    //从下到上
                res[k++] = matrix[i][left];
            }
            left ++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_146SpiralArray s = new Solution_146SpiralArray();
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        s.spiralArray(nums);
    }
}
