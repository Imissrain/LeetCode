package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 *
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]*/
@SuppressWarnings("all")
public class twoSum {
    //这是我想的
    //    public int[] twoSum(int[] nums, int target) {
//        int result[]=new int[2];
//        if(nums.length==0){
//            result[0]=-1;
//            result[1]=-1;
//            return result;
//        }
//        int i=0,j=nums.length-1;
//        while(i<j){
//            for(;i<j;){
//                if(nums[i]+nums[j]==target){
//                    result[0]=i;
//                    result[1]=j;
//                    return result;
//                }else {
//                    j--;
//                }
//            }
//            j=nums.length-1;
//            i++;
//        }
//        return result;
//    }
    //这是神犇的
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        int result[]=new int[2];
        for(int i=0;i<nums.length;i++){
            int tmp=target-nums[i];
            if(map.get(tmp)!=null){
                result[0]=map.get(tmp);
                result[1]=i;
            }else {
                map.put(nums[i],i);
            }
        }

        return result;
    }
}
