package tree.binary_tree;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 */
public class Tree_538 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;

        System.out.println(convertBST(node1));

    }

    public static TreeNode convertBST(TreeNode root) {
        //val以及其出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        help(root, map);
        set(root, map);
        return root;
    }

    public static void help(TreeNode root, HashMap<Integer, Integer> map) {
        if (root != null) {
            if (map.containsKey(root.val)) {
                map.put(root.val, map.get(root.val) + 1);
            } else {
                map.put(root.val, 1);
            }
            help(root.left, map);
            help(root.right, map);
        }
    }
    public static void set(TreeNode node, HashMap<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        int temp = node.val;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            if (entry.getKey() > temp) {
                node.val += entry.getKey() * entry.getValue();
            }
        }
        set(node.left, map);
        set(node.right, map);
    }
}
