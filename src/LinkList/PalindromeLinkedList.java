package LinkList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 *  回文链表
 * 请检查一个链表是否为回文链表。
 *
 * 进阶：
 * 你能在 O(n) 的时间和 O(1) 的额外空间中做到吗？*/
@SuppressWarnings("all")
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
@SuppressWarnings("all")
public class PalindromeLinkedList {

    /*
    version1:栈
     */
    public boolean isPalindrome1(ListNode head) {
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

    /*
    version2:快慢指针找到中点 然后逆置  根据逆置之后的从头开始对比 注意链表长度为奇数还是偶数 奇数刚好可以走到中间 偶数只能走到前一个
    当链表节点数为偶数的时候 fast只会走到null前一个 此时slow向后多走一个 注意fast在走的时候要同时满足next和next.next都不为null 避免三个节点的特殊情况
     */
    public boolean isPalindrome(ListNode head){
        if(head==null||head.next==null)
            return true;
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        if(fast.next!=null){
            slow=slow.next;
        }
        ListNode first=slow;
        ListNode reverse=null;
        while(first!=null){
            ListNode second=first.next;
            first.next=reverse;
            reverse=first;
            first=second;
        }
        while(reverse!=null){
            if(reverse.val== head.val){
                reverse=reverse.next;
                head=head.next;
            }else {
                return false;
            }
        }
        return true;
    }
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            boolean ret = new PalindromeLinkedList().isPalindrome(head);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
