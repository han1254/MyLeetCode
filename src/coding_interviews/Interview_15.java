package coding_interviews;

import java.util.Stack;

/**
 * 面试题15. 二进制中1的个数
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 */
public class Interview_15 {
    public static void main(String[] args) {
        System.out.println(hammingWeight2(9));
    }
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int sum = 0;
        String str = transToB(n);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                sum++;
            }
        }
        return sum;
    }

    public static String transToB(int n) {
        StringBuilder builder = new StringBuilder();
        while(n > 0) {
//            stack.push(n % 2);
            builder.append(n % 2);
            n = n / 2;
        }
        return builder.toString();

    }

    // you need to treat n as an unsigned value
    public static int hammingWeight2(int n) {
        int sum = 0;
       while (n > 0) {
           sum += n & 1;
           n = n >>> 1;
       }
        return sum;
    }

}
