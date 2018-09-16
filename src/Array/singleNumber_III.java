package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * 137. 只出现一次的数字 II
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 * */
@SuppressWarnings("all")
public class singleNumber_III {
    //HashMap暴力解法
    public static int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer integer = map.get(nums[i]);
            map.put(nums[i],integer==null?1:map.get(nums[i])+1);
        }
        for(Map.Entry entry : map.entrySet()){
            if(entry.getValue().equals(1)){
                return (int) entry.getKey();
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int []nums={2,2,2,3};
        System.out.println(singleNumber(nums));
    }
}
