package tree.binary_tree;

import java.util.*;

/**
 * 501. 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 */
public class Tree_501 {
    public static void main(String[] args) {

    }

    private static int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        search(root, numsMap);
        int max = 0;
        for (Map.Entry<Integer, Integer> next : numsMap.entrySet()) {
            if (next.getValue() > max) {
                max = next.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> next : numsMap.entrySet()) {
            if (next.getValue() > max) {
                max = next.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> next : numsMap.entrySet()) {
            if (next.getValue() == max) {
                list.add(next.getKey());
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private static void search(TreeNode node, HashMap<Integer, Integer> map) {
        if (node != null) {
            if (!map.containsKey(node.val)) {
                map.put(node.val, 1);
            } else {
                map.put(node.val, map.get(node.val) + 1);
            }
            search(node.left, map);
            search(node.right, map);
        }

    }


}
