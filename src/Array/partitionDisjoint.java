package Array;

import java.util.TreeSet;

/**
 * 915. 分割数组
 * 给定一个数组 A，将其划分为两个不相交（没有公共元素）的连续子数组 left 和 right， 使得：

 left 中的每个元素都小于或等于 right 中的每个元素。
 left 和 right 都是非空的。
 left 要尽可能小。
 在完成这样的分组后返回 left 的长度。可以保证存在这样的划分方法。



 示例 1：

 输入：[5,0,3,8,6]
 输出：3
 解释：left = [5,0,3]，right = [8,6]
 示例 2：

 输入：[1,1,1,0,6,12]
 输出：4
 解释：left = [1,1,1,0]，right = [6,12]


 提示：

 2 <= A.length <= 30000
 0 <= A[i] <= 10^6
 可以保证至少有一种方法能够按题目所描述的那样对 A 进行划分。
 * @author gkyan
 */
@SuppressWarnings("all")
public class partitionDisjoint {
    //周赛B题 T了
    public static int partitionDisjoint1(int[] A) {
        if(A.length==2)
            return 1;
        int ans=Integer.MAX_VALUE;
        int maxsum=Integer.MAX_VALUE;
        int left=1;
        for( left=1;left<A.length;left++){
            int leftarr[]=new int[left];
            int rightarr[]=new int[A.length-left];
            int leftmax=Integer.MIN_VALUE;
            int rightmin=Integer.MAX_VALUE;
            boolean flag=true;
            for(int i=0;i<leftarr.length;i++){
                leftarr[i]=A[i];
                leftmax=Math.max(leftmax,leftarr[i]);
            }
            int index=left;
            for(int i=0;i<rightarr.length;i++){
                rightarr[i]=A[index++];
                rightmin=Math.min(rightmin,rightarr[i]);
            }
            if(rightmin<leftmax)
                flag=false;
            if(flag){
                ans=Math.min(ans,left);
            }
        }
        return ans;
    }

    //研究了下排行榜的代码 其实还是类似于贪心的思想吧 既然要左边都比右边小 我维护一个数组 让数组的每个值都等于他前面相邻的最大值 在维护一个数组 从尾到头 每个位置都是后面相邻部分的最小值 然后这两个数组去比较 如果某max数组的值小于min数组的值 说明就该从此分割
    public static int partitionDisjoint(int[] a) {
        int n = a.length;
        int[] pre = new int[n+1];
        for(int i = 0;i < n;i++){
            pre[i+1] = Math.max(pre[i], a[i]);
        }
        int[] suf = new int[n+1];
        suf[n] = 999999999;
        for(int i = n-1;i >= 0;i--){
            suf[i] = Math.min(suf[i+1], a[i]);
        }
        for(int i = 1;i < n;i++){
            if(pre[i] <= suf[i]){
                return i;
            }
        }
        throw new RuntimeException();
    }
    public static void main(String[] args) {
        int arr[]={5,0,3,8,6};
        System.out.println(partitionDisjoint(arr));
    }
}
