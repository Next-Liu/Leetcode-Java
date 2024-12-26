package traceback;

import java.util.Arrays;

public class Solution_2212MaximumPoints {
    /**
     * @param numArrows:箭的数量
     * @param aliceArrows:alice在0-11上得到的箭的数量
     * @return
     */
    int max = 0;
    int[] ans = new int[12];//存储每一轮 Bob 使用的箭头数量，最终将会返回这个数组。

    public void dfs(int[] aliceArrows, int index, int point, int remain, int[] cur) {
        if (index == 11) {
            if (point > max) {
                max = point;
                ans = Arrays.copyOf(cur, cur.length);
                if (remain > 0) {  //还有剩余箭头放在第一个区域
                    ans[0] = remain;
                }
            }
            return;
        }
        //bob本轮选择要这个区域的分数
        if (remain > aliceArrows[index + 1]) {
            cur[index + 1] = aliceArrows[index + 1] + 1;
            dfs(aliceArrows, index + 1, point + index + 1, remain - aliceArrows[index + 1] - 1, cur);
        }
        //bob本轮不要这个区域的分数
        cur[index + 1] = 0;
        dfs(aliceArrows, index + 1, point, remain, cur);
    }

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        dfs(aliceArrows,0,0,numArrows,ans);
        return ans;
    }
}
