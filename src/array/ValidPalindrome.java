package array;

import java.util.Calendar;

/**
 *
 * https://leetcode.com/problems/valid-palindrome/
 * 125. Valid Palindrome
 * Easy
 *
 * 982
 *
 * 2636
 *
 * Add to List
 *
 * Share
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        String test = "a a";
        System.out.println(isPalindrome(test));
    }

    /**
     * Runtime: 3 ms, faster than 64.57% of Java online submissions for Valid Palindrome.
     * Memory Usage: 39.3 MB, less than 26.78% of Java online submissions for Valid Palindrome.
     * @param s
     * @return
     *
     * 感觉自己就是个魔鬼，写那么多if else，而且很多if else都是根据报错更改的
     * 平时写的时候还真不一定能写出来，这种方式不可取
     */
    private static boolean isPalindrome(String s) {
        if (s.equals("")) {
            return true;
        }
        int end = s.length() - 1;
        char[] chars = s.toLowerCase().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == end) {
                return true;
            }
            //如果i指针指向的是符号，持续往后推进
            if (!Character.isLetterOrDigit(chars[i])) {
                //如果都是符号，循环到头，返回true
                if (i == chars.length - 1) {
                    return true;
                }
                continue;
            }
            //如果end指针指向的是符号，让end继续往前推进
            while(!Character.isLetterOrDigit(chars[end])) {
                end--;
            }
            //推进了end，进行检查，查看是否与i指向的字符相等
            if (chars[i] != chars[end]) {
                return false;
            }
            //如果指针指向了一处，说明了是回文，对应奇数
            if (i == end) {
                return true;
            }
            //对应偶数，如果i指针指向的下一个是end并且i与end指向的两个字符相等
            if (i + 1 == end && chars[i] == chars[end]) {
                return true;
            }
            //如果以上都不符合，继续下一次循环
            end--;
        }
        return false;
    }

}
