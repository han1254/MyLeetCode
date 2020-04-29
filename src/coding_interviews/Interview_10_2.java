package coding_interviews;

import java.util.HashMap;

public class Interview_10_2 {

    public static HashMap<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(numWays(48));
    }
    public static int numWays(int n) {
        int result;
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if(n == 0) {
            map.put(n, 0);
            result = 1;
        } else if(n == 2) {
            map.put(n, 2);
            result = 2;
        } else if(n == 1) {
            map.put(n, 1);
            result = 1;
        } else {
            //这个取模的位置很关键，
            result = (numWays(n - 2) + numWays(n - 1) ) % 1000000007;
            map.put(n, result);
        }
        return result ;
    }

    public int numTry(int n) {
        int a = 1, b = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (a + b ) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

   

}
