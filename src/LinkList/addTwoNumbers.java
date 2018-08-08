package LinkList;

import org.junit.Test;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.*;

/**
 * 445. 两数相加 II
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 *
 *
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶:
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 */
@SuppressWarnings("all")
public class addTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //将暴力进行到底 思路:两个链表先转成数组 然后从尾到头模拟相加 每次使用一个add来模拟进位 在一个数组走完的时候 注意弥上原来的 弥的时候也要注意进位 最后当进位等于1时 申请新数组最高位置1 剩下的部分复制进去
        if(l1==null && l2!=null)
            return l2;
        if(l1!=null &&l2==null)
            return l1;
        if(l1==null && l2==null)
            return null;
        ListNode phead=l1;
        int l1_len=0;
        int l2_len=0;
        while(phead!=null){
            l1_len++;
            phead=phead.next;
        }
        int []l1_arr=new int[l1_len];
        phead=l1;
        for(int i=0;i<l1_len;i++){
            l1_arr[i]=phead.val;
            phead=phead.next;
        }
        phead=l2;
        while(phead!=null){
            l2_len++;
            phead=phead.next;
        }
        int []l2_arr=new int[l2_len];
        phead=l2;
        for(int i=0;i<l2_len;i++){
            l2_arr[i]=phead.val;
            phead=phead.next;
        }
        int ans[]=new int[Math.max(l1_len,l2_len)];
        int add=0;
        int i,j,k;
        for( i=l1_arr.length-1,j=l2_arr.length-1,k=ans.length-1;i>=0&&j>=0&&k>=0;i--,j--){
            int sum=l1_arr[i]+l2_arr[j]+add;
            add=0;
            if(sum>=10){
               sum=sum%10;
               ans[k]=sum;
               k--;
               add++;
            }else {
             ans[k]=sum;
             k--;
            }
        }
        if(i>=0){
            for(int a=i;a>=0;a--){
                int sum=ans[k]=l1_arr[a]+add;
                add=0;
                if(sum>=10){
                    sum=sum%10;
                    ans[k]=sum;
                    k--;
                    add++;
                }else {
                    ans[k]=sum;
                    k--;
                }
            }
        }
        if(j>=0){
            for(int a=j;a>=0;a--){
                int sum=ans[k]=l2_arr[a]+add;
                add=0;
                if(sum>=10){
                    sum=sum%10;
                    ans[k]=sum;
                    k--;
                    add++;
                }else {
                    ans[k]=sum;
                    k--;
                }
            }
        }
        if(add==1){
            int []tmp=new int[ans.length+1];
            tmp[0]=1;
            System.arraycopy(ans,0,tmp,1,ans.length);
            ans=tmp;
        }
        System.out.println(Arrays.toString(l1_arr)+"  "+Arrays.toString(l2_arr)+"   "+Arrays.toString(ans));
        ListNode res=new ListNode(0);
        phead=res;
        for(int b=0;b<ans.length;b++){
            ListNode tmpnode=new ListNode(ans[b]);
            phead.next=tmpnode;
            phead=phead.next;
        }
        return res.next;
    }

}
