package LinkList;
/**
 * 环形链表
 * 给定一个链表，判断链表中是否有环。
 *
 * 进阶：
 * 你能否不使用额外空间解决此题？
 * */
@SuppressWarnings("all")
public class hasCycle {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //总体思路：利用快慢指针解决 慢的每次走1 快的每次走2 当他俩相等的时候说明链表是有环的

    public boolean hasCycle(ListNode head) {
//        if(head==null)
//            return false;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){//因为fast走的比slow快 所以判断是否走完只需要判断fast即可
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return true;
        }
        return false;
    }
}
