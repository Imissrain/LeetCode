package LinkList;
/**
 * 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * */
@SuppressWarnings("all")
public class mergeTwoLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2!=null)
            return l2;
        if(l1!=null && l2==null)
            return l1;
        if(l1 ==null && l2==null)
            return null;
        ListNode fake=new ListNode(0);
        ListNode res=fake;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                res.next=l1;
                l1=l1.next;
            }else {
                res.next=l2;
                l2=l2.next;
            }
            res=res.next;
        }
        if(l1!=null)
            res.next=l1;
        else
            res.next=l2;
        return fake.next;
    }
}
