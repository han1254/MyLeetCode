package array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 169. Majority Element
 * https://leetcode.com/problems/majority-element/description/
 * Easy
 *
 * 2656
 *
 * 207
 *
 * Add to List
 *
 * Share
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MaxElement {

    public static void main(String[] args) {

        System.out.println(majorityElement(new int[]{1,1,1,1,1,5,3,6,1,8,9}));
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i :
                nums) {
            if (hashMap.containsKey(i)) {
                hashMap.put(i, hashMap.get(i) + 1);
            } else {
                hashMap.put(i, 1);
            }
        }
        int target;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : hashMap.entrySet()) {
            if (integerIntegerEntry.getValue() > nums.length / 2) {
                return integerIntegerEntry.getKey();
            }
        }

        return 0;

    }

}
