package merge_sorted_array;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 */
public class MergeArray {

    public static void main(String[] args) {

        int[] a = new int[]{1, 2, 4, 6, 8, 0, 0, 0, 0, 0};
        int[] b = new int[]{3, 5, 7, 9, 11};
        merge(a, 5, b, 5);
        System.out.println(Arrays.toString(a) + " " + Arrays.toString(b));

    }

    /**
     * 这些大佬是真滴牛逼
     * 这个大佬的答案
     * |
     * |
     * ——> https://leetcode-cn.com/u/charleswone/
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m--+--n;

        while(n>=0) {
            nums1[i--] = m>=0 && nums1[m]>nums2[n] ? nums1[m--] : nums2[n--];
        }
    }

//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int p = m-- + n-- - 1;
//        while (m >= 0 && n >= 0) {
//            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
//        }
//
//        while (n >= 0) {
//            nums1[p--] = nums2[n--];
//        }
//    }

}
