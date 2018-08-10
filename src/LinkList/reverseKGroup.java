package LinkList;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 25. k个一组翻转链表
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * */
@SuppressWarnings("all")
public class reverseKGroup {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack=new Stack<>();
        ListNode tmp=head;
        for(int i=0;i<k;i++){
            if(head!=null){
                stack.push(head);
            }else {
                return tmp;
            }
            head=head.next;
        }
        ListNode first=stack.pop();
        ListNode res=first;
        for(int i=0;i<k-1;i++){
            first.next=stack.pop();
            first=first.next;
        }
        first.next=reverseKGroup(head,k);
        return res;
    }
}
