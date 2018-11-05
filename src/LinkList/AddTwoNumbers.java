package LinkList;

import org.junit.Test;

import java.util.Arrays;

/**
 * 2. 两数相加
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * */
@SuppressWarnings("all")
public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //和上一个链表相加问题不同的是 这个存储是逆序的 需要得到目标数组后分别进行反转 然后得到的结果数组也要进行翻转 相加的时候也要注意进位问题
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
        int []tmpl1_arr=new int[l1_arr.length];
        for(int z=0,x=l1_arr.length-1;z<tmpl1_arr.length&&x>=0;z++,x--){
            tmpl1_arr[z]=l1_arr[x];
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
        int []tmpl2_arr=new int[l2_arr.length];
        for(int z=0,x=l2_arr.length-1;z<tmpl2_arr.length&&x>=0;z++,x--){
            tmpl2_arr[z]=l2_arr[x];
        }
        int ans[]=new int[Math.max(l1_len,l2_len)];
        int add=0;
        int i,j,k;
        for( i=tmpl1_arr.length-1,j=tmpl2_arr.length-1,k=ans.length-1;i>=0&&j>=0&&k>=0;i--,j--){
            int sum=tmpl1_arr[i]+tmpl2_arr[j]+add;
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
                int sum=ans[k]=tmpl1_arr[a]+add;
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
                int sum=ans[k]=tmpl2_arr[a]+add;
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
        int []tmparr=new int[ans.length];
        for(int z=0,x=ans.length-1;z<tmparr.length&&x>=0;z++,x--){
            tmparr[z]=ans[x];
        }
//        System.out.println(Arrays.toString(tmparr));
        for(int b=0;b<tmparr.length;b++){
            ListNode tmpnode=new ListNode(tmparr[b]);
            phead.next=tmpnode;
            phead=phead.next;
        }
        return res.next;
    }
    @Test
    public void fun(){

    }
}
