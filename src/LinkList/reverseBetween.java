package LinkList;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Stack;

/**
 * 92. 反转链表 II
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * */
@SuppressWarnings("all")
public class reverseBetween {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //将链表所有元素保存下来 然后根据区间截取 存入栈中 然后再遍历 根据栈修改节点值 投机取巧 QAQ
        if(head==null ||m==n)
            return head;
        Stack<Integer> stack=new Stack<>();
        ListNode pHead=head;
        ArrayList<Integer>arrayList=new ArrayList<>();
        while(pHead!=null){
            arrayList.add(pHead.val);
            pHead=pHead.next;
        }

        for(int i=0;i<arrayList.size();i++){
            if(i>=m-1&&i<=n-1){
                stack.push(arrayList.get(i));
            }
        }
//        System.out.println(Arrays.toString(arrayList.toArray()));
        System.out.println(Arrays.toString(stack.toArray()));
        int count=1;
        ListNode head1=head;
        while(head1!=null&&!stack.isEmpty()){
            if(count>=m&&count<=n){
                int val=stack.pop();
                head1.val=val;
            }
            head1=head1.next;
            count++;
        }
        return head;
    }
}
