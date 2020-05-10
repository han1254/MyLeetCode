package coding_interviews;

import sun.reflect.generics.tree.Tree;

public class Interview_27 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        TreeNode node = mirrorTree(node1);

    }
    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode resultNode = new TreeNode(root.val);
        helper(resultNode, root);
        return resultNode;
    }

    public static void helper(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null ) {
            return;
        }
        if (node2.right != null) {
            node1.left = new TreeNode(node2.right.val);
        }
        if (node2.left != null) {
            node1.right = new TreeNode(node2.left.val);
        }

        helper(node1.left, node2.right);
        helper(node1.right, node2.left);
    }
}
