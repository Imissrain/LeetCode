package LinkList;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 New Playground
 Imissrain

 138. 复制带随机指针的链表
 题目描述提示帮助提交记录社区讨论阅读解答
 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。

 要求返回这个链表的深度拷贝。

 您是否在真实的面试环节中遇到过这道题目呢？

 */
@SuppressWarnings("all")
public class copyRandomList {
    class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
     };
    public RandomListNode copyRandomList(RandomListNode head) {
        //第一次从头遍历先将节点存入map   第二次从头遍历 先获得当前节点node node的next等于cur.next node的random等于cur.random cur后移
        Map<RandomListNode,RandomListNode> map=new HashMap<>();
        RandomListNode cur=head;
        while(cur!=null){
            RandomListNode node=new RandomListNode(cur.label);
            map.put(cur,node);
            cur=cur.next;
        }
        cur=head;
        while(cur!=null){
            RandomListNode randomListNode = map.get(cur);
            randomListNode.next=map.get(cur.next);
            randomListNode.random=map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);
    }

}
