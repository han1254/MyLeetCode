package coding_interviews;

import java.util.HashMap;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode builderList(int...nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode temp = head;
        for (int i = 1; i < nums.length; i++) {
            head.next = new ListNode(nums[i]);
            head = head.next;
        }
        return temp;
    }
}
