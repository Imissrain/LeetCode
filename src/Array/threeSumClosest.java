package Array;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * <p>
 * <p>
 * <p>
 * <p>
 * 题目描述
 * 评论 (121)
 * 题解
 * 提交记录
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
@SuppressWarnings("all")
public class threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        //初始最接近为 0 1 2三个和
        int closeSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int l = i + 1, r = nums.length - 1;
            //像3sum那样 两边指针走 接近的话更新closesum 小了左边走 大了右边走 刚好等于target就return
            while (l < r) {
                int sum = nums[l] + nums[r] + nums[i];
                if (Math.abs(sum - target) < Math.abs(closeSum - target)) {
                    closeSum = sum;
                }
                if (sum > target) {
                    r--;
                } else if (sum < target)
                    l++;
                else
                    return target;
            }
        }
        return closeSum;
    }
}
