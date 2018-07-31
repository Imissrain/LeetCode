package LinkList;

/**
 * 876. 链表的中间结点
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 */
@SuppressWarnings("all")
public class middleNode {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode middleNode(ListNode head) {
        //快慢指针 注意判断链表结束的标志看快的就可以 快的没走完慢的也就没走完
        if(head==null || head.next==null)
            return head;
        ListNode slow=head;
        ListNode fast=head;
        int count=0;
        while(fast!=null && fast.next!=null){
            count++;
            slow=slow.next;
            fast=fast.next.next;
        }
        if(count%2==0)
            return slow.next;
        else
            return slow;
    }
}
