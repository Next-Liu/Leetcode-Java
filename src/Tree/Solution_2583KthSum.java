package Tree;

import java.util.*;

public class Solution_2583KthSum {
    public long kthLargestLevelSum(TreeNode root, int k) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Long> ans = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            long total = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                total += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            ans.add(total);
        }
        Collections.sort(ans, new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o2.compareTo(o1);
            }
        });
        return k > ans.size() ? -1 : ans.get(k - 1);
    }

}
