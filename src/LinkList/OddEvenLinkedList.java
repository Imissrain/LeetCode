package LinkList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 328. 奇偶链表
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * [2,1,3,5,6,4,7]
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 * */
@SuppressWarnings("all")

public class OddEvenLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode oddEvenList(ListNode head) {
        //申请奇数head 和偶数头head 并申请两个节点维护他们 先算出链表长度 然后依次遍历 奇数就接到奇数 偶数就接到偶数 跳出循环后偶数的next置为null 然后连接起来返回即可
        if(head==null)
            return null;
        if(head!=null&&head.next==null || head!=null&&head.next!=null&&head.next.next==null)
            return head;
        ListNode evn=new ListNode(0);
        ListNode odd=new ListNode(0);
        ListNode fake_evn=new ListNode(0);
        ListNode fake_odd=new ListNode(0);
        ListNode head_=head;
        int flag=1;
        while(head_.next!=null){
            head_=head_.next;
            flag++;
        }
        fake_evn=evn;
        fake_odd=odd;
        int count=0;
        while(flag>0){
            count++;
            if(count%2!=0){
                odd.next=head;
                odd=odd.next;
            }else {
                evn.next=head;
                evn=evn.next;
            }
            head=head.next;
            flag--;
        }
        evn.next=null;
        odd.next=fake_evn.next;
        return fake_odd.next;
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

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            ListNode ret = new OddEvenLinkedList().oddEvenList(head);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}
