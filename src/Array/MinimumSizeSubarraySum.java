package Array;

/**
 * 209. 长度最小的子数组
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例:
 *
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class MinimumSizeSubarraySum {
    /*
    滑动窗口 定义i j代表窗口的左右边界 sum小于s的时候 右边界一直移动相加 当sum大于s 舍去左边界的值 左边界移动向右
     */
    public int minSubArrayLen(int s, int[] nums) {
        int i=0,j=0;
        int sum=0;
        int len=nums.length+1;
        while (i<nums.length){
            if(j<nums.length&&sum<s){
                sum+=nums[j];
                j++;
            }else {
                sum-=nums[i];
                i++;
            }

            if(sum>=s){
                len=Math.min(len,j-i);
            }
        }
        return len==nums.length+1?0:len;
    }
    public static void main(String[] args) {
        int s=7;
        int[] nums={2,3,1,2,4,3};
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(s,nums));
    }
}
