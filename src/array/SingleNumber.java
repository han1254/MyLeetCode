package array;

import java.util.HashMap;
import java.util.List;

public class SingleNumber {

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,3,3,5,6,6,7,7,9,9};
        System.out.println(singleNumber(arr));
        System.out.println(singleNumber2(arr));
    }

    public static int singleNumber(int[] list) {
        int result = 0;
        for (int i :
                list) {
            result ^= i;
        }
        return result;

    }

    /**
     * Runtime: 7 ms, faster than 22.49% of Java online submissions for Single Number.
     * Memory Usage: 40.5 MB, less than 86.67% of Java online submissions for Single Number.
     * @param list
     * @return
     */
    public static int singleNumber2(int[] list) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i :
                list) {
            if (map.containsKey(i)) {
                int temp = map.get(i);
                map.put(i, temp + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (int i :
                list) {
            if (map.get(i) == 1) {
                return i;
            }
        }
        return 0;
    }

}
