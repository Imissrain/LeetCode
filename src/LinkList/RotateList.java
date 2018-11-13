package LinkList;

import jdk.internal.org.objectweb.asm.tree.LdcInsnNode;

/**
 * 61. 旋转链表
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * */

public class RotateList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //刚开始看错题了。。首先找到最后一位 然后再找开始偏移的那位 注意取余 然后将 最后一位指向当前头 头指针指向偏移的那位 偏移位的前一位置为null
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0)
            return head;
        int len=1;
        ListNode pTail=head;
        while(pTail.next!=null){
            len++;
            pTail=pTail.next;
        }
        System.out.print(len);
        if(len==1)
            return head;
        ListNode pMid=head;
        ListNode pHead=head;
        k=k%len;
        for(int i=0;i<len-k-1;i++){
            pMid=pMid.next;
        }
        pTail.next=pHead;
        pHead=pMid.next;
        pMid.next=null;
        head=pHead;
        return head;
    }
}
