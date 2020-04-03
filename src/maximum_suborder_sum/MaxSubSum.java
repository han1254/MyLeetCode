package maximum_suborder_sum;

/**
 * 53.最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSubSum {

    public static void main(String[] args) {
        int[] a = new int[]{1,3,0,-1,-3,8,-9,10};
        System.out.println(maxSubArray(a));
    }

    /**
     * 暴力解法
     * 执行用时 :248 ms
     * 内存消耗 :39.8 MB
     * 我们要获得最大子序列，最直接的思想就是双重循环
     * 每次循环起点作为子序列的起点
     * 然后从起点开始往后推进
     * 记录最大的和
     * @param nums 需要找到最大子序列的目标序列
     * @return 返回最大子序列的和
     */
    public static int maxSubArray(int[] nums) {
        int temp;
        //我添加的，用来观察最大子序列的起始下标
        int start = 0;
        int end = 0;
        int max = nums[0];
        //如果只有一个元素，直接返回就行
        if(nums.length == 1) {
            return nums[0];
        }
        //暴力解法，双重循环
        for (int i = 0; i < nums.length; i++) {
            //temp记录每次循环的起始元素的值
            temp = nums[i];
            start = i;
            //如果起始元素大于max，就把起始元素赋值给max
            //为啥？
//            输入：
//            [-1,0,-2]
//            输出：
//            -1
//            预期：
//            0
            //加入我们的最大子序列只有一个数字，后面的循环是进行加和，就是-2，没有地方能够考虑这个零了
            if(temp > max) {
                max = temp;
            }
            for(int j = i + 1; j < nums.length; j++) {
                temp += nums[j];
                if (temp > max) {
                    max = temp;
                    end = j;
                }
            }
        }
        System.out.println(start);
        System.out.println(end);
        return max;
    }

}
