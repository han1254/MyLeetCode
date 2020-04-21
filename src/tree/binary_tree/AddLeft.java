package tree.binary_tree;

public class AddLeft {
    static int result = 0;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(sumOfLeftLeaves(node1));
    }

//    public static int sumOfLeftLeaves(TreeNode node) {
//        return sumOfLeftLeavesHelper(node, false);
//    }
//
//    public static int sumOfLeftLeavesHelper(TreeNode root, boolean isLeft) {
//        if (isLeft) {
//            result += root.val;
//        }
//        if (root.left != null) {
//            sumOfLeftLeavesHelper(root.left, true);
//        }
//        if (root.right != null) {
//            sumOfLeftLeavesHelper(root.right, false);
//        }
//        return result;
//    }

    public static int sumOfLeftLeaves(TreeNode node) {
        return helper(node, false);
    }

    public static int helper(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        int result = 0;
        if (isLeft && node.left == null && node.right == null) {
           result += node.val;
        }
        result += helper(node.left, true);
        result += helper(node.right, false);
        return result;
    }
}
