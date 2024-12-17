package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class Solution_116Connection {
    public void Process(List<Node> list) {
        for (int j = 0; j < list.size(); j++) {
            if (j == list.size() - 1) {
                Node node = list.get(j);
                node.next = null;
                break;
            } else {
                Node node = list.get(j);
                node.next = list.get(j + 1);
            }
        }
    }

    public Node connect(Node root) {
//        填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL
        /**
         *       1->null
         *    2 ----->3->null
         *  4-->5-->6-->7->null
         */
        LinkedList<Node> queue = new LinkedList<>();
        List<List<Node>> ans = new ArrayList<>();
        if (root == null) {
            return null;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Node> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.removeFirst();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                temp.add(node);
            }
            ans.add(temp);
        }
        for (List<Node> list : ans) {
            Process(list);
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        root.left = node2;
        root.right = node3;
        Solution_116Connection ss = new Solution_116Connection();
        ss.connect(root);
    }
}
