package LinkList;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.Stack;

/**
 * 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * */
@SuppressWarnings("all")

public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //递归版本
    public ListNode reverseList1(ListNode head) {
        //中止条件
        if(head==null || head.next==null)
            return head;
        else {
            ListNode newhead=reverseList1(head.next);
            head.next.next=head;
            head.next=null;
            return newhead;
        }
    }
    //栈实现
    public ListNode reverseList(ListNode head){
        Stack<Integer> stack=new Stack<>();
        ListNode tmp=head;
        while(tmp!=null){
            stack.push(tmp.val);
            tmp=tmp.next;
        }
        tmp=head;//warning
        System.out.println(stack.size());
        int length=stack.size();
        for(int i=0;i<length;i++){
            head.val=stack.pop();
            head=head.next;
        }
        return tmp;//注意这里一定是从头返回
    }
}
