package tree.binary_tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 513. 找树左下角的值
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * 示例 1:
 *
 * 输入:
 *
 *     2
 *    / \
 *   1   3
 *
 * 输出:
 * 1
 *
 *
 * 示例 2:
 *
 * 输入:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * 输出:
 * 7
 *
 *
 * 注意: 您可以假设树（即给定的根节点）不为 NULL。
 *
 * 通过次数12,678提交次数18,318
 */
public class Tree_513 {

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 81.72%
     * 的用户
     * 内存消耗 :
     * 38.9 MB
     * , 在所有 Java 提交中击败了
     * 73.91%
     * 的用户
     * 目前为止的最佳战绩😀
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int level = 1;
        help(root, level, true, map);
        int max = 0;
        for (Map.Entry<Integer, Integer> next : map.entrySet()) {
            if (next.getKey() > max) {
                max = next.getKey();
            }
        }
        return map.get(max);
    }
    public void help(TreeNode node, int level, boolean isLeft, HashMap<Integer, Integer> map) {
        if(node != null) {
            if(node.left == null && node.right == null) {
                if(!map.containsKey(level)) {
                    map.put(level, node.val);
                }
            }
            help(node.left, level + 1, true, map);
            help(node.right,level + 1,false,  map);
        }

    }

}
