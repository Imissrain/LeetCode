package Array;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 *
 *
 *
 * 题目描述
 * 评论 (164)
 * 题解
 * 提交记录
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
/*
    二分找到目标值之后 从中心往两边扩展
 */
public class FindFirstandLastPositionofElementinSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if(target>nums.length)
            return new int[]{-1,-1};
        int[] ans=new int[2];
        int search = BinarySearch(nums, target);
        if(search==-1){
            return new int[]{-1,-1};
        }else {
            int indexL=search;
            int intdexR=search;
            while(indexL>0){
                if(nums[indexL-1]==target)
                    indexL--;
                else
                    break;
            }
            while(intdexR<nums.length){
                if(intdexR+1<nums.length&&nums[intdexR+1]==target)
                    intdexR++;
                else
                    break;
            }
            ans[0]=indexL;
            ans[1]=intdexR;
            return ans;
        }
    }

    public int BinarySearch(int[] nums,int target){
        int l=0,r=nums.length-1;
        while(l<=r){
            int mid=l+((r-l)>>1);
            if(nums[mid]>target)
                r=mid-1;
            else if(nums[mid]<target)
                l=mid+1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int []nums={1};
        System.out.println(Arrays.toString(new FindFirstandLastPositionofElementinSortedArray().searchRange(nums,1)));
    }
}
