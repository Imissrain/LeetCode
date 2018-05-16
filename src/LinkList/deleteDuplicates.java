package LinkList;
/**
 * 83. 删除排序链表中的重复元素
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * */
@SuppressWarnings("all")
public class deleteDuplicates {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return head;
        ListNode fakenode=new ListNode(0);
        fakenode.next=head;
        while(head.next!=null){
            if(head.val==head.next.val){//当前和下一个的节点的值相等 越过指向下一个 否则当前节点后移
                head.next=head.next.next;
            }else {
                head= head.next;
            }
        }
        return fakenode.next;
    }
}
