package Array;

import java.util.Arrays;

/**
 * 169. 求众数
 * <p>
 * <p>
 * <p>
 * <p>
 * 题目描述
 * 评论 (142)
 * 官方题解
 * 提交记录
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {
    /*
     ans从第一个数字开始 设置count为1 从第二个开始循环 相同的++ 不同的-- 减到0的时候换下一个数字
     */
    public int majorityElement(int[] nums) {
        int count = 1;
        int ans = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (ans == nums[i])
                count++;
            else {
                count--;
                if (count == 0)
                    ans = nums[i + 1];
            }

        }
        return ans;
    }


    /*
    排序取中间
     */
    public int majorityElementII(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
