package LinkList;

import org.junit.Test;

/**
 * 24. 两两交换链表中的节点
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 说明:
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * */
@SuppressWarnings("all")

public class SwapNodesinPairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode swapPairs(ListNode head) {

        //交换两个相临节点 first.next=second.next current.next=second current.next.next=first current向前走两步
      if(head==null ||head.next==null)
          return head;
      ListNode fakenode=new ListNode(0);
      fakenode.next=head;
      ListNode current=fakenode;
      while(current.next!=null && current.next.next!=null){
          ListNode first=current.next;
          ListNode second=current.next.next;
          first.next=second.next;
          current.next=second;
          current.next.next=first;
          current=current.next.next;
      }
      return fakenode.next;
    }

}
