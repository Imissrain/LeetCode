package LinkList;

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * 23. 合并K个排序链表
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * */
@SuppressWarnings("all")

public class MergekSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //暴力 先搞出来两个链表合并 然后从i=1开始 每一位的值都等于加上前一位的值 最后返回末尾呢个   重复相加
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null ||lists.length==0)
            return null;
        for(int i=1;i<lists.length;i++){
            lists[i]=mergeTwoLists(lists[i],lists[i-1]);
        }
        return lists[lists.length-1];
    }
}
