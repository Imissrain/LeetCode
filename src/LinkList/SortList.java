package LinkList;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

/**
 * 148. 排序链表
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
@SuppressWarnings("all")

public class SortList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //获取中间节点
    public ListNode getMiddleNode(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    //归并
    public ListNode mergeList(ListNode headA,ListNode headB){
        ListNode fakenode=new ListNode(0);
        ListNode cur=fakenode;
        while(headA!=null&&headB!=null){
            if(headA.val<=headB.val){
                cur.next=headA;
                headA=headA.next;
            }else {
                cur.next=headB;
                headB=headB.next;
            }
            cur=cur.next;
        }
        cur.next=headA==null?headB:headA;
        return fakenode.next;
    }
    //基于链表的归并排序 思路：先找到链表的中间节点 将链表一分为二  然后进行归并操作
    public ListNode sortList(ListNode head) {
        if(head==null ||head.next==null)
            return head;
        ListNode middle=getMiddleNode(head);
        ListNode next=middle.next;
        middle.next=null;//将链表分开
        return mergeList(sortList(head),sortList(next));
    }






    //O(n2)超时 QWQ
    public ListNode sortList1(ListNode head) {
        if(head==null || head.next==null)
            return head;
        int count=1;
        ListNode phead=head;
        while (phead.next != null) {
            count++;
            phead=phead.next;
        }
//        System.out.println(count);
        ListNode pphead=head;
        for(int i=1;i<count;i++){
            pphead=head;
            while(pphead.next!=null){
                if(pphead.val>pphead.next.val){
                    swap(pphead,pphead.next);
                }
                pphead=pphead.next;
            }
        }
        return head;
    }
    public void swap(ListNode l1,ListNode l2){
        l1.val^=l2.val;
        l2.val^=l1.val;
        l1.val^=l2.val;
    }
}
