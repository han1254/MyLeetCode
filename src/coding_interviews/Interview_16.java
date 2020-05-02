package coding_interviews;

/**
 * 面试题16. 数值的整数次方
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 *
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class Interview_16 {

    public static void main(String[] args) {
        System.out.println(myPow(2.0000, -2147483648));
    }

    public static double myPow(double x, int n) {
        double temp = 1;
        double result = 1;
        long b = Math.abs(n);
        if (b < 0) {
            b = -b;
        }
        if (n == 0) {
            return 1;
        } else {
//            for (int i = 0; i < Math.abs(n); i++) {
//                result *= x;
//            }
            while(b > 0) {
                if ((b & 1) == 1) {
                    result *= x;
                }
                x *= x;
                b >>= 1;
            }
            return n > 0 ? result : temp / result;
        }
    }
}
