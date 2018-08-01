package LinkList;

import java.util.*;

/**
 * 142. 环形链表 II
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 说明：不允许修改给定的链表。
 *
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 */
@SuppressWarnings("all")
public class detectCycle {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode detectCycle(ListNode head) {
        //先找相遇节点 然后从相遇节点和头节点分别出发 再次相遇 就是入环节点
        if (head == null || head.next==null)
            return null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                break;
            }
        }
        if(slow==fast){
            fast=head;
            while(fast!=slow){
                slow=slow.next;
                fast=fast.next;
            }
            return slow;
        }
        return null;
    }
}
