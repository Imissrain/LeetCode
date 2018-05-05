package LinkList;

import java.util.Stack;

/**
 *  回文链表
 * 请检查一个链表是否为回文链表。
 *
 * 进阶：
 * 你能在 O(n) 的时间和 O(1) 的额外空间中做到吗？*/
@SuppressWarnings("all")
public class isPalindromeLinkList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public boolean isPalindrome(ListNode head) {
        //每道题都要注意意判空
        if(head==null)
            return true;
        ListNode tmp=head;
        //先push 再pop
        Stack<Integer> stack=new Stack<>();
        while(tmp!=null){
            stack.push(tmp.val);
            tmp=tmp.next;
        }
        boolean flag=true;
        while(head!=null){
            if(stack.pop()!=head.val)
                return false;
            head=head.next;
        }
        return flag;
    }
}
