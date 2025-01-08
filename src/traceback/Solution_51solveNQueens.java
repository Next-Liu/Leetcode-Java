package traceback;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_51solveNQueens {
    /**
     * 将n皇后问题解成n个皇后在n*n的棋盘上，每个皇后只能放在一个位置，且不能处于同一行、同一列、同一斜线上。
     */
    private int n; // 棋盘大小
    private List<List<String>> ans = new ArrayList<>(); // 存储所有解
    private int[] col; // 记录每一行皇后所在的列

    /**
     * 检查在 (r, c) 位置放置皇后是否有效
     */
    private boolean isValid(int r, int c) {
        for (int R = 0; R < r; R++) {
            int C = col[R];
            // 检查是否在同一列或同一斜线上
            if ((C+R) == (c+r) || c==C || (R-C) == (r-c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 深度优先搜索（DFS）求解N皇后问题
     *
     * @param r 当前处理的行
     * @param s 剩余可用的列
     */
    private void dfs(int r, Set<Integer> s) {
        if (r == n) {
            // 找到一个解，将其添加到结果中
            List<String> board = new ArrayList<>();
            for (int c : col) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb.append(i == c ? 'Q' : '.');
                }
                board.add(sb.toString());
            }
            ans.add(board);
            return;
        }

        for (int c : s) {
            if (isValid(r, c)) {
                col[r] = c; // 在第 r 行第 c 列放置皇后
                Set<Integer> newSet = new HashSet<>(s); // 创建一个新的集合，避免修改原集合
                newSet.remove(c); // 移除当前列
                dfs(r + 1, newSet); // 递归处理下一行
            }
        }
    }

    /**
     * 求解N皇后问题
     *
     * @param n 棋盘大小
     * @return 所有可能的解
     */
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.col = new int[n]; // 初始化列记录数组
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            s.add(i); // 初始化可用列
        }
        dfs(0, s); // 从第0行开始搜索
        return ans;
    }

    public static void main(String[] args) {
        Solution_51solveNQueens solution_51solveNQueens = new Solution_51solveNQueens();
        List<List<String>> lists = solution_51solveNQueens.solveNQueens(4);
        System.out.println(lists);
    }
}
