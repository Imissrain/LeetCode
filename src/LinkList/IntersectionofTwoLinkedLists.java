package LinkList;
/**
 * 160. 相交链表
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 *
 *
 * 例如，下面的两个链表：
 *
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 * 在节点 c1 开始相交。
 *
 *
 *
 * 注意：
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * */
@SuppressWarnings("all")
public class IntersectionofTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //计算两个链表的长度差n 长的先走n步 然后一起出发 等两个指向同一个的时候返回节点 否则返回null
        if(headA==null || headB==null)
            return null;
        int lengthA=getLength(headA);
        int lengthB=getLength(headB);
        int n=lengthA-lengthB;
        ListNode pA=headA;
        ListNode pB=headB;
        for(int i=0;i<Math.abs(n);i++){
            if(n>0){
                pA=pA.next;
            }else {
                pB=pB.next;
            }
        }
        while(pA!=null && pB!=null){
            if(pA==pB)
                return pA;
            pB=pB.next;
            pA=pA.next;
        }
        return null;
    }
    public int getLength(ListNode node){
        if(node==null)
            return 0;
        int count=1;
        while(node.next!=null){
            count++;
            node=node.next;
        }
        return count;
    }
}
