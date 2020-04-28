package coding_interviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 面试题56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class EveryDayTry_1 {

    public int[] singleNumbers(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i :
                nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        int position = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
               result.add(entry.getKey());
            }
        }
        int[] arr = new int[result.size()];
        for (int i :
                result) {
            arr[position++] = i;
        }
        return arr;
    }
}
