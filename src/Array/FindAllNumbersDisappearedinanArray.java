package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 *448. 找到所有数组中消失的数字
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 */
@SuppressWarnings("all")

public class FindAllNumbersDisappearedinanArray {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        //桶思想 先填满数组 然后找为0的下标返回
        if(nums.length==0) {
            return new ArrayList<>();
        }
        List<Integer>list=new ArrayList<>();
        int max=nums.length;
        int []arr=new int[max+1];
        for(int i=0;i<nums.length;i++){
            arr[nums[i]]=nums[i];
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i]==0){
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int nums[]={1,1};
        System.out.println(findDisappearedNumbers(nums).toString());
    }
}
