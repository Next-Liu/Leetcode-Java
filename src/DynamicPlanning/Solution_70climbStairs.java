package DynamicPlanning;

public class Solution_70climbStairs {
    private int[] cache = new int[45];

    public int climbStairs(int n) {
        if (n == 1) {
            cache[0] = 1;
            return 1;
        }
        if (n == 2) {
            cache[1] = 2;
            return 2;
        }
        if (cache[n - 1] != 0) {
            return cache[n - 1];
        }
        int res = climbStairs(n - 1) + climbStairs(n - 2);
        cache[n-1] = res;
        return res;
    }
}
