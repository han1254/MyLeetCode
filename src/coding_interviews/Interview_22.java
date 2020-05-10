package coding_interviews;

import java.util.Stack;

/**
 * 面试题22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 *
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 * 通过次数22,910提交次数29,089
 */
public class Interview_22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = null;
        while(head != null) {
            stack.push(head);
            head = head.next;
        }
        for (int i = 0; i < k; i++) {
            temp = stack.pop();
        }
        return temp;
    }

    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode temp = new ListNode(head.val);
        temp.next = head.next;
        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            temp = temp.next;
        }
        return temp;
    }

}
