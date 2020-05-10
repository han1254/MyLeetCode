package coding_interviews;

import java.util.Arrays;

/**
 * 面试题21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 */
public class Interview_21 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(exchange(arr)));
    }

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时 :
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 47.07%
     * 的用户
     * 内存消耗 :
     * 48 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param nums
     * @return
     */
    public static int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {

            if ((nums[left] & 1) == 0 && (nums[right] & 1) == 1) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            if ((nums[left] & 1) == 1) {
                left++;
            }
            if ((nums[right] & 1) == 0) {
                right--;
            }
        }
        return nums;
    }
}
