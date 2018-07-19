package Array;
/**
 * 704. Binary Search
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * Given a sorted (in ascending order) integer array nums of n elements and a target value,
 * write a function to search target in nums. If target exists, then return its index, otherwise return -1.
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 * Example 2:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 * */
@SuppressWarnings("all")
public class Binarysearch {
    public static int search(int[] nums, int target) {
        //二分模板 注意while条件的控制 l<=r
//        if(nums.length==1&&nums[0]==target)
//            return 0;
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=(l+r)/2;
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
        int nums[]={5};
        int target=5;
        System.out.println(search(nums,target));
    }
}
