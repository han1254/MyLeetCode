package array;

/**
 * https://leetcode.com/problems/factorial-trailing-zeroes/submissions/
 */
public class FactorialTrailingZeroes {


    public int trailingZeroes(int n) {
        // int t =0;
        // if(n < 5) {
        //     return 0;
        // }
        // while(n > 1) {
        //     n = n/5;
        //     t+=n;
        // }
        // return t;
        if(n >= 5) {
            return n/5 +  trailingZeroes(n / 5);
        } else {
            return 0;
        }
    }

}
