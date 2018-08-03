package LinkList;

import java.util.HashSet;
import java.util.Set;

/**
 *817. Linked List Components
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * We are given head, the head node of a linked list containing unique integer values.
 *
 * We are also given the list G, a subset of the values in the linked list.
 *
 * Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.
 *
 * Example 1:
 *
 * Input:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
 * Example 2:
 *
 * Input:
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
 * Note:
 *
 * If N is the length of the linked list given by head, 1 <= N <= 10000.
 * The value of each node in the linked list will be in the range [0, N - 1].
 * 1 <= G.length <= 10000.
 * G is a subset of all values in the linked list.
 */
@SuppressWarnings("all")
public class numComponents {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public int numComponents(ListNode head, int[] G) {
        //先将值存入哈希表中 然后遍历链表 当前节点的值包含在哈希表中 结果+1 继续从当前节点开始往下遍历 直到断开 当前节点挪动到断开节点continue
        Set<Integer> set=new HashSet<>();
        for(Integer integer:G){
            set.add(integer);
        }
        ListNode pre=head;
        int ans=0;
        while(pre!=null){
            if(set.contains(pre.val)){
                ans++;
                ListNode p=pre.next;
                while(p!=null&&set.contains(p.val)){
                    p=p.next;
                }
                pre=p;
                continue;
            }
            pre=pre.next;
        }
        return ans;
    }
}
