package Tree;

import java.util.*;

public class Solution_508Comparator {
    public int[] findFrequentTreeSum(TreeNode root) {
        /**
         * 返回出现次数最多的子树元素和
         */
        HashMap<Integer, Integer> countMap = new HashMap<>();
        countFuc(root, countMap);
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(countMap.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        List<Integer> ans = new ArrayList<>();
        int last = entryList.get(0).getValue();
        for (int i = 0; i < entryList.size(); i++) {
            int currentValue = entryList.get(i).getValue();
            if (currentValue == last) {
                ans.add(entryList.get(i).getKey());
            } else {
                break;
            }
        }
        int[] res = new int[ans.size()];
        for (int j = 0; j < ans.size(); j++) {
            res[j] = ans.get(j);
        }
        return res;
    }

    public int countFuc(TreeNode root, HashMap<Integer, Integer> countMap) {
        if (root.left == null && root.right == null) {
            if (countMap.containsKey(root.val)) {
                Integer value = countMap.get(root.val);
                value += 1;
                countMap.put(root.val, value);
            } else {
                countMap.put(root.val, 1);
            }
            return root.val;
        }
        int leftVal = root.left != null ? countFuc(root.left, countMap) : 0;
        int rightVal = root.right != null ? countFuc(root.right, countMap) : 0;
        int totalVal = root.val + leftVal + rightVal;
        if (countMap.containsKey(totalVal)) {
            Integer value = countMap.get(totalVal);
            value += 1;
            countMap.put(totalVal, value);
        } else {
            countMap.put(totalVal, 1);
        }
        return totalVal;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node3.right = node6;
        node4.left = node5;
        Solution_508Comparator solution_508 = new Solution_508Comparator();
        HashMap<Integer, Integer> countMap = new HashMap<>();
        solution_508.findFrequentTreeSum(root);
    }
}
