package LinkList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 82. 删除排序链表中的重复元素 II
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * */
@SuppressWarnings("all")
public class RemoveDuplicatesfromSortedListII {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        //if-else解题大法：两个指针 pPre指向fake pCur指向head 如果cur和cur.next相等 cur往后走 直到走完相同节点 然后就要开始列举了 当fake和pre在一起时 cur的下一个又是空的 说明他们都存在重复返回null 当fake和pre不在一起时，cur下一个为空 说明存在这样一个节点 在这里直接return 其他情况都继续遍历 当cur和cur.next不想等 cur和pre同步往前走一步
        if (head == null || head.next == null)
            return head;
        ListNode fakenode=new ListNode(0);
        fakenode.next=head;
        ListNode pCur=head;
        ListNode pPre=fakenode;
        while(pCur.next!=null){
            if(pCur.val!=pCur.next.val){
                pCur=pCur.next;
                pPre=pPre.next;
            }else {
                while(pCur.next!=null&&pCur.val==pCur.next.val)
                    pCur=pCur.next;
                if(pCur.next!=null)
                    pCur=pCur.next;
                else if(pCur.next==null&&pPre==fakenode)
                    return null;
                else if(pCur.next==null&&pPre!=fakenode){
                    pPre.next=pCur.next;
                    return fakenode.next;
                }
            }
            pPre.next=pCur;
        }
        return fakenode.next;
    }
}
