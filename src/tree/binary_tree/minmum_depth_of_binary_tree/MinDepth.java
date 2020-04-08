package tree.binary_tree.minmum_depth_of_binary_tree;

import tree.binary_tree.maximum_depth_of_binary_tree.MaxDepBT;

public class MinDepth {

    /**
     * Definition for binary tree
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public int run(MaxDepBT.TreeNode treeNode) {
        int left = 0;
        int right = 0;
        if (treeNode == null) {
            return 0;
        }
        if (treeNode.left == null) {
            return run(treeNode.right) + 1;
        }

        if (treeNode.right == null) {
            return run(treeNode.left) + 1;
        }

        left = run(treeNode.left);
        right = run(treeNode.right);
        return Math.min(left, right);

    }

}
