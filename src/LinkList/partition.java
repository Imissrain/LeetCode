package LinkList;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * 86. 分隔链表
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * */
@SuppressWarnings("all")
public class partition {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode partition(ListNode head, int x) {
        //双指针 一个存小于x的 一个存大于等于x的 记得在循环结束后 big后可能会有残留的值 next为null就好
        if(head==null || head.next==null)
            return head;
        ListNode little=new ListNode(0);
        ListNode plittle=little;
        ListNode big=new ListNode(0);
        ListNode pbig=big;
        while(head!=null){
            if(head.val<x){
                plittle.next=head;
                plittle=plittle.next;
            }else {
                pbig.next=head;
                pbig=pbig.next;
            }
            head=head.next;
        }
        pbig.next=null;
        plittle.next=big.next;
        return little.next;
    }
}
