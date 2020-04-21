package tree.binary_tree.bfs;

import tree.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HouseRobberIII {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node2_1 = new TreeNode(2);
        TreeNode node2_2 = new TreeNode(3);
        TreeNode node3_2 = new TreeNode(3);
        TreeNode node3_4 = new TreeNode(1);
        root.left = node2_1;
        root.right = node2_2;
        node2_1.right = node3_2;
        node2_2.right = node3_4;
        System.out.println(rob(root));

    }

    public static  int rob(TreeNode root) {
        int result1 = 0;
        int result2 = 0;
       Queue<TreeNode> robberQueue = new LinkedList<>();
       if (root == null) {
           return 0;
       }
       List<List<Integer>> values = new ArrayList<>();
       robberQueue.add(root);
       while(!robberQueue.isEmpty()) {
           List<Integer> tempList = new ArrayList<>();
           int len = robberQueue.size();
           for (int i = 0; i < len; i ++) {
               TreeNode tempNode = robberQueue.poll();
               if (tempNode != null) {
                   tempList.add(tempNode.val);
                   if (tempNode.left != null){
                       robberQueue.add(tempNode.left);
                   }
                   if (tempNode.right != null) {
                       robberQueue.add(tempNode.right);
                   }
               } else {
                   break;
               }
           }
          values.add(tempList);
       }
       int count = values.size();
       for (int i = 1; i <= count; i++) {
           if (i % 2 == 0) {
               for (int temp :
                       values.get(i - 1)) {
                   result2 += temp;
               }
           } else {
               for (int temp :
                       values.get(i - 1)) {
                   result1 += temp;
               }
           }
       }

       return Math.max(result1, result2);
    }

    public int rob2(TreeNode root) {
        /*
        你是我见过最聪明的小偷
        */
        /*
        //递归思想（不要深入递归函数体，只需知道递归函数的功能，以及找到跳出递归的边界条件）
        //思路：
        //能盗取的最高金额为 抢劫该节点+抢劫该节点的左孩子的左右子树+抢劫该节点的右孩子的左右子树
        //与 抢劫该节点的左子树+抢劫该节点的右子树的和  的最大值
        //执行用时 1005ms  原因是出现了很多重复的计算，可使用动态规划解决
        if(root == null) return 0;
        int val = 0;
        if(root.left != null) val += rob(root.left.left) + rob(root.left.right);
        if(root.right != null) val += rob(root.right.left) + rob(root.right.right);
        return Math.max(rob(root.left) + rob(root.right),val + root.val);
        */

        //动态规划
        //思路：
        //定义一个数组res,长度为2,res[0]表示不抢该节点可获得最大值,res[1]表示抢劫该节点可获得最大值
        //方法helper(r)意为：在以r为根节点的树中,返回抢劫根节点与不抢劫根节点可获得的最大值
        //执行用时 2ms
        int[] res = helper(root);
        return Math.max(res[0],res[1]);
    }
    public int[] helper(TreeNode r){
        if(r == null) return new int[2];//边界条件，r为null时，跳出
        int[] left = helper(r.left);//对于以r.left为根的树，计算抢劫根节点(r.left)与不抢劫根节点可获得最大金额. left[0]则为不抢r.lrft可获得的最大金额,left[1]则为抢劫r.left可获得的最大金额  以下right[] 分析同理
        int[] right = helper(r.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);//计算不抢劫当前根节点可获得的最大金额(那么其左右子树可以随便抢)
        res[1] = r.val + left[0] + right[0];//计算若抢劫根节点可获得的最大金额(此时,其左右子树的根节点不能被抢)
        return res;
    }

    public static void bfs(TreeNode node,  Queue<TreeNode> queue) {

    }

}
