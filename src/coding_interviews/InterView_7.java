package coding_interviews;

import java.util.HashMap;

/**
 * 面试题07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 *
 */
public class InterView_7 {

    private HashMap<Integer, Integer> map = new HashMap<>();
    private int[] pre;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int position = 0; position < inorder.length; position++) {
            map.put(inorder[position], position);
        }
        pre = preorder;
        return helper(0, 0, preorder.length - 1);
    }

    public TreeNode helper(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(pre[root]);
        int i = map.get(pre[root]);
        node.left = helper(root + 1, left, i - 1);
        //i - left + 1该根结点的左子树的个数
        node.right = helper(root + i - left + 1, i + 1, right);
        return node;
    }
}
