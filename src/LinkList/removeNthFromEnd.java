package LinkList;
/**
 * 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 * */
@SuppressWarnings("all")
public class removeNthFromEnd {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n<0)
            return head;
        ListNode fake=new ListNode(0);
        fake.next=head;
        ListNode delete=fake;
        for(int i=0;i<n;i++){
            if(head==null)
                return null;
            head=head.next;
        }
        while (head!=null){
            head=head.next;
            delete=delete.next;
        }
        delete.next=delete.next.next;
        return fake.next;
    }
}
