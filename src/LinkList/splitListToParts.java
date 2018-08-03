package LinkList;
/**
 * 725. Split Linked List in Parts
 * 给定具有头节点根的（单个）链表，编写一个函数将链表拆分为k个连续链表“部分”。
 *
 * 每个部分的长度应尽可能相等：两个部分的大小不应超过1.这可能导致某些部分为空。
 *
 * 零件应按输入列表中的出现顺序排列，之前出现的零件的大小应始终大于或等于稍后出现的零件。
 *
 * 返回ListNode列表，表示形成的链接列表部分。
 *
 * 例1-> 2-> 3-> 4，k = 5 // 5等份[[1]，[2]，[3]，[4]，null]
 * */
@SuppressWarnings("all")
public class splitListToParts {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        //先算出链表长度然后分情况讨论：k>=len 链表没走完 直接放进去 走完了存null head一直向前迭代 k<len  count/k算出一组平均几个 然后count%k算出剩余的 再从头分配给ave leave-- 然后新建节点开始循环即可
        ListNode pheaed=root;
        int count=0;
        ListNode []ans=new ListNode[k];
        while(pheaed!=null){
            count++;
            pheaed=pheaed.next;
        }
//        System.out.println(count);
        pheaed=root;
        if(k>=count){
            for(int i=0;i<ans.length;i++){
                if(pheaed!=null){
                    ListNode tmp=new ListNode(pheaed.val);
                    ans[i]=tmp;
                    pheaed=pheaed.next;
                }else {
                    ans[i]=null;
                }
            }
        }else{
            pheaed=root;
            int leave=count%k;
            for(int i=0;i<k;i++){
                int ave=count/k;
                if(leave>0){
                    ave++;
                    leave--;
                }
                ListNode node=new ListNode(0);
                ListNode cur=node;
                for(int j=0;j<ave;j++){
                    ListNode tmp=new ListNode(pheaed.val);
                    cur.next=tmp;
                    pheaed=pheaed.next;
                    cur=cur.next;
                }
                ans[i]=node.next;
            }
        }
        return ans;
    }
}
