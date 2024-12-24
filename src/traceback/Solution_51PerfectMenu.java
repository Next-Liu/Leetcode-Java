package traceback;

public class Solution_51PerfectMenu {
    /**
     * @param materials:第   j 种食材的数量
     * @param cookbooks:    表示制作第 i 种料理需要第 j 种食材的数量
     * @param attribute:    表示第 i 道料理的美味度 x 和饱腹感 y
     * @param limit:在饱腹感不小于 limit 的情况下，请返回勇者可获得的最大美味度。如果无法满足饱腹感要求，则返回 -1。
     * @return
     */
    int maxPerfect = -1;
    public void dfs(int[] materials, int[][] cookbooks, int[][] attribute, int limit, int perfect, int start, int full) {
        if (full >= limit) {
            maxPerfect = Math.max(perfect, maxPerfect);
        }
        for (int i = start; i < cookbooks.length; i++) {
            if (useCookbooks(materials, cookbooks, i)) {
                perfect += attribute[i][0];
                full += attribute[i][1];
            } else {
                continue;
            }
            dfs(materials, cookbooks, attribute, limit, perfect, i + 1, full);
            //还原食材
            revCookbooks(materials, cookbooks, i);
            perfect -= attribute[i][0];
            full -= attribute[i][1];
        }
    }

    // 判断是否可以使用该料理
    public boolean useCookbooks(int[] materials, int[][] cookbooks, int i) {
        boolean flag = true;
        for (int j = 0; j < cookbooks[i].length; j++) {
            materials[j] -= cookbooks[i][j];
            if (materials[j] < 0) flag = false;
        }
        if (!flag) revCookbooks(materials, cookbooks, i);
        return flag;
    }

    // 不可用的话还原料理
    public void revCookbooks(int[] materials, int[][] cookbooks, int i) {
        for (int j = 0; j < cookbooks[i].length; j++) {
            materials[j] += cookbooks[i][j];
        }
    }

    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        //遍历起点
        for (int j = 0; j < cookbooks.length; j++) {
            dfs(materials, cookbooks, attribute, limit, 0, j, 0);
        }
        return maxPerfect;
    }
}
