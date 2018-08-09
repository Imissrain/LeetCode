package LinkList;

/**
 * 430. Flatten a Multilevel Doubly Linked List
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
 *
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
 *
 * Example:
 *
 * Input:
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 *
 * Output:
 * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
 */
@SuppressWarnings("all")
public class flatten {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    };
    public Node flatten(Node head) {
        if(head==null)
            return null;
        for(Node p=head;p!=null;p=p.next){
            //for遍历一遍链表 每次记录当前节点的next 如果当前节点child不为空 当前节点的next等于child child的prev等于当前节点 申请tmp指向 child的头 child走完时 tmp的next等于next next的prev等于tmp
            Node next=p.next;//记录next  因为要从这里切断
            if(p.child!=null){
                p.next=p.child;
                p.child.prev=p;
                p.child=null;
                Node tmp=p.next;
                while(tmp.next!=null){
                    tmp=tmp.next;
                }
                tmp.next=next;
                next.prev=tmp;
            }
        }
        return head;
    }
}
