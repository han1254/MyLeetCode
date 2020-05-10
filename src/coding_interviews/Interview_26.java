package coding_interviews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 面试题26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 *
 * 0 <= 节点个数 <= 10000
 */
public class Interview_26 {

    public static List<TreeNode> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode test = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        System.out.println(isSubStructure2(node1, test));
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        TreeNode node;
        if ((node = dfs(A, B.val)) == null) {
            return false;
        }
        return dfs(node, B);
    }
    public TreeNode dfs(TreeNode root, int val) {
        Queue<TreeNode> frontier = new LinkedList<>();
        frontier.add(root);
        while(!frontier.isEmpty()) {
            TreeNode temp = frontier.poll();
            if (temp == null) {
                continue;
            }
            if (temp.val == val) {
                return temp;
            }
            frontier.add(temp.left);
            frontier.add(temp.right);
        }
        return null;
    }
    public boolean dfs(TreeNode root1, TreeNode root2) {
        if (!(root1 == null && root2 == null) || (root1.val != root2.val)) {
            return false;
        }
        return dfs(root1.left, root2.left) && dfs(root1.right, root2.right);
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 31.78%
     * 的用户
     * 内存消耗 :
     * 41.3 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param A
     * @param B
     * @return
     */
    public static boolean isSubStructure2(TreeNode A, TreeNode B) {

        TreeNode node;
        getTarget(A, B.val);
        if (list.size() == 0) {
            return false;
        }
        for (TreeNode i:
             list) {
            if (isSame(i, B)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b != null) {
            return false;
        }

        if (b == null) {
            return true;
        }
        if (a.val != b.val) {
            return false;
        }
        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }

    public static void getTarget(TreeNode A, int target) {
        if (A == null) {
            return;
        }
        if (A.val == target) {
            list.add(A);
        }
        getTarget(A.left, target);
        getTarget(A.right, target);
    }
}
