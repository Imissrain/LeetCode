package LinkList;
/**
 * 203. 删除链表中的节点
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * */
@SuppressWarnings("all")
public class removeElements {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //版本1

    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return head;
        ListNode fakenode=new ListNode(0);
        fakenode.next=head;
        ListNode cur=head;
        ListNode pre=fakenode;
        while(cur!=null){
            if(cur.val==val){
                pre.next=cur.next;
                cur=pre.next;
            }else {
                pre=cur;
                cur=cur.next;
            }
        }
        return fakenode.next;
    }
    //fakenode=cur cur.next.val==val 删除 否则cur=cur.next


    //版本2
    public ListNode removeElements1(ListNode head, int val) {
        if(head==null)
            return head;
        ListNode fakenode=new ListNode(0);
        fakenode.next=head;
        ListNode cur=fakenode;
        while(cur.next!=null){
            if(cur.next.val==val){
                cur.next=cur.next.next;
            }else {
                cur=cur.next;
            }
        }
        return fakenode.next;
    }
}
