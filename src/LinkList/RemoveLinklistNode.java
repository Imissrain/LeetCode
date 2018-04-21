package LinkList;
/**删除链表的结点
 请编写一个函数，使其可以删除某个链表中给定的（非末尾的）节点，您将只被给予要求被删除的节点。

 比如：假设该链表为 1 -> 2 -> 3 -> 4  ，给定您的为该链表中值为 3 的第三个节点，那么在调用了您的函数之后，该链表则应变成 1 -> 2 -> 4 。
 * */
@SuppressWarnings("all")
public class RemoveLinklistNode {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //复制下一个节点 然后删除下一个节点
    public void deleteNode(ListNode node) {
        if(node.next==null)
            return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
