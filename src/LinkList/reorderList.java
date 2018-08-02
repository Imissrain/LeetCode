package LinkList;

import java.util.*;

/**
 * 143. 重排链表
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
@SuppressWarnings("all")
public class reorderList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public void reorderList(ListNode head) {
        //如果暴力不是为切题，那将毫无意义 算长度 将值存进数组 head不为空的情况下顺序放一个 倒序放一个
        if(head==null || head.next==null)
            return;
        ListNode phead=head;
        int count=0;
        while(phead!=null){
            count++;
            phead=phead.next;
        }
        System.out.println(count);
        int []arr=new int[count];
        phead=head;
        int index=0;
        while(phead!=null){
            arr[index]=phead.val;
            index++;
            phead=phead.next;
        }
        phead=head;
        for(int i=0,j=arr.length-1;i<arr.length&&j>=0&&phead!=null;){
            System.out.println(arr[i]);
            phead.val=arr[i];
            phead=phead.next;
            i++;
            System.out.println(arr[j]);
            phead.val=arr[j];
            phead=phead.next;
            j--;
            if(i==j){
                phead.val=arr[i];
                break;
            }

        }
        return;
    }
}
