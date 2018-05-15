package Array;
/**
 * 35. 搜索插入位置
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * */
@SuppressWarnings("all")
public class searchInsert {
    public int searchInsert(int[] nums, int target) {
        if(nums==null)
            return -1;
        if(nums.length==0)
            return 0;
        int left=0;
        int right=nums.length-1;
        int middle;
        while(left<=right){
             middle=(left+right)/2;//二分   middle每次都要变化
            if(nums[middle]==target)
                return middle;
            if(nums[middle]>target)
                right=middle-1;
            else
                left=middle+1;
        }
        return left;
    }
}
