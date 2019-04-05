package Array;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * 15. 三数之和
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
@SuppressWarnings("all")
/*
* threesum
* */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0)
            return null;
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1]/*跳过重复的*/)) {
                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];/*转化为两数之和*/
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        lists.add(Arrays.asList(nums[l], nums[r],nums[i]));
                        /*遇到相等的之后 两边指针同时移动*/
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        /*左边小了左边移动*/
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                    } else {
                        /*右边小了右边移动*/
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    }
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {

    }
}

