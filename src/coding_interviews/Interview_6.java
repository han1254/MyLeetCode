package coding_interviews;

import java.util.ArrayList;
import java.util.List;

public class Interview_6 {

    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(head, list);
        int[] result = new int[list.size()];
        int position = 0;
        for(int i = list.size() - 1; i >= 0; i--) {
            result[position++] = list.get(i);
        }
        return result;
    }

    public void helper(ListNode node, ArrayList<Integer> arrList) {
        if(node != null) {
            arrList.add(node.val);
            helper(node.next, arrList);
        }
    }

}
