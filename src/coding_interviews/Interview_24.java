package coding_interviews;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.Stack;

/**
 * 面试题24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 */
public class Interview_24 {

    public static void main(String[] args) {
        ListNode listNode = ListNode.builderList(1, 2, 3, 4, 5);
        listNode = reverseList2(listNode);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public static ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        while(head != null) {
            stack.push(head.val);
            head = head.next;
        }
        ListNode newHead = new ListNode(stack.pop());
        ListNode temp = newHead;
        while (!stack.isEmpty()) {
            temp.next = new ListNode(stack.pop());
            temp = temp.next;
        }
        return newHead;
    }

    public static ListNode reverseList2(ListNode node) {
        ListNode curr = node;
        ListNode pre = null;
        ListNode temp = null;
        while(curr != null) {
            temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    public static ListNode reverseList3(ListNode node) {
        if (node == null) {
            return null;
        }
        Stack<ListNode> stack =  new Stack<>();
        while(node != null) {
            ListNode temp = node;
            stack.push(temp);
            node = node.next;
        }
        ListNode head = stack.peek();
        while (!stack.isEmpty()) {
            ListNode temp1 = stack.pop();
            ListNode temp2 = stack.isEmpty() ? null : stack.peek();
            temp1.next = temp2;
            if (!(temp2 == null)) {
                temp2.next = null;
            }
        }
        return head;
    }

}
