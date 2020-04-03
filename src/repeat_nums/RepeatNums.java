package repeat_nums;

import java.util.Arrays;

/**
 * 题目地址：
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class RepeatNums {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

    //[1, 1, 2, 3, 3, 3, 4, 5, 6, 6]
    private static int removeDuplicates(int[] nums) {
        int placePtr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[placePtr]) {
                nums[++placePtr] = nums[i];
            }
        }
        return placePtr + 1;
    }
}
