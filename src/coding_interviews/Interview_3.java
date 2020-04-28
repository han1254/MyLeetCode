package coding_interviews;

import java.util.HashMap;

public class Interview_3 {
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i :
                nums) {
            if (map.containsKey(i)) {
                return i;
            } else {
                map.put(i, 1);
            }

        }
        return 0;
    }
}
