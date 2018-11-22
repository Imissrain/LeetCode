package DynamicProgromming;

import java.util.Arrays;

/**
 * 300. 最长上升子序列
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * */
@SuppressWarnings("all")
public class LongestIncreasingSubsequence {
    //申请一个巨大的一维数组 来记录当前位置的最大的上升长度，当后一个位置的值大于前一个位置的值并且最终位置的dp大于当前位置 更新当前位置的dp 最后遍历找最大值
    public static int lengthOfLIS(int[] nums) {
        if(nums.length==0)
            return 0;
        int dp[]=new int [999999];
        Arrays.fill(dp,1);
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]&&dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                }
            }
        }
        int ans=1;
        for(int i=0;i<dp.length;i++){
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int []nums={10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
}
