package Array;

import java.util.HashMap;

@SuppressWarnings("all")
/**
 * 167. 两数之和 II - 输入有序数组
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class TwoSumII_Inputarrayissorted {
    /*
    version1: hashmap
     */
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] ans=new int[2];
        for(int i=0;i<numbers.length;i++){
            int val=target-numbers[i];
            if(map.get(val)!=null){
                ans[0]=map.get(val);
                ans[1]=i;
            }else {
                map.put(numbers[i],i);
            }
        }
        ans[0]++;
        ans[1]++;
        return ans;
    }

    /*
    version2:双指针 首先判断首尾是否等于target 大了的话尾-- 小了头++
     */
    public int[] twoSum2(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        while(i<j){
            if(nums[i]+nums[j]==target){
                return new int[]{i+1,j+1};
            }else if(nums[i]+nums[j]>target){
                j--;
            }else{
                i++;
            }
        }
        return new int[2];
    }
}
