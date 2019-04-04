package Array;


import java.util.Arrays;

/**
 * 239. 滑动窗口最大值
 * 题目描述
 * 评论 (47)
 * 题解
 * 提交记录
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口最大值。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------------         -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 注意：
 * <p>
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 输入数组的大小，且输入数组不为空。
 * <p>
 * 进阶：
 * <p>
 * 你能在线性时间复杂度内解决此题吗？
 */
/*
暴力 index设为静态的 记得每次更新
 */
public class SlidingWindowMaximum {
    static int index=0;
    private int[] maxSlidingWindow(int[] nums, int k) {
        index=0;
        if (nums.length < k || k == 0)
            return new int[0];
        int[] arr=new int[nums.length-k+1];

        for (int i = 0; i < nums.length-k+1; i++) {
            arr=addMax(nums,i,k,arr);
        }
        return arr;
    }

    private int[] addMax(int[] nums, int i, int k, int[] arr) {
        int max=Integer.MIN_VALUE;
        for(int j=i;j<i+k;j++){
            max=Math.max(nums[j],max);
        }
        arr[index++]=max;
        return arr;
    }

    public static void main(String[] args) {
        int[] nums={1};
        System.out.println(Arrays.toString(new SlidingWindowMaximum().maxSlidingWindow(nums,1)));
    }
}
