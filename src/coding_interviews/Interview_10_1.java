package coding_interviews;

import java.util.ArrayList;
import java.util.HashMap;

public class Interview_10_1 {


    private ArrayList<Integer> list = new ArrayList<>();
    private static HashMap<Integer, Integer> map = new HashMap<>();

    /**
     * 老子超时了😭😭
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n == 1) {
            return 1;
        } else if(n == 0) {
            return 0;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }


    public static void main(String[] args) {
        int num = fib2(48);
        System.out.println(num);
    }

    /**
     * 记忆化递归
     * @param n
     * @return
     */
    public static int fib2(int n) {
        return helper(n);
    }

    /**
     * 记忆化递归
     * @param n
     * @return
     */
    public static int helper(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 1) {
            map.put(1, 1);
            return 1;
        } else if(n == 0) {
            map.put(0, 0);
            return 0;
        } else {
            int result = fib(n - 1) + fib(n - 2);
            map.put(n, result > 1000000007 ? result % 1000000007 : result);
            return map.get(n);
        }
    }
}
