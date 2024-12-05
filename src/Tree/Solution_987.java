package Tree;

import java.util.*;

/**
 * 二叉树的垂序遍历
 * （0,0）
 * （1,-1）       （1,1）
 * （2,0）   （2,2）
 */
public class Solution_987 {
    /**
     * 所有元素表示为（row,col,val），按照col分组col 相同的分到同一组，每组只保留 val，
     * 每组的 val 按照 row 从小到大排序，row 相同的按照 val 从小到大排序。
     */
    public void dfs(TreeNode root, int row, int col, Map<Integer, List<int[]>> groups) {
        if (root == null) {
            return;
        }
        // k代表当前处理的key
        groups.computeIfAbsent(col, k -> new ArrayList<>()).add(new int[]{row, root.val});
        dfs(root.left, row + 1, col - 1, groups);
        dfs(root.right, row + 1, col + 1, groups);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // key是col ，value是（row，value）
        Map<Integer, List<int[]>> groups = new TreeMap<>();
        dfs(root, 0, 0, groups);
        List<List<Integer>> ans = new ArrayList<>(groups.size());
        for (List<int[]> q : groups.values()) {
            List<Integer> values = new ArrayList<>(q.size());
            q.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
                }
            });
            for (int[] p : q) {
                values.add(p[1]);
            }
            ans.add(values);
        }
        return ans;
    }
}
