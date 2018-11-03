package Math;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. 求众数
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * */
@SuppressWarnings("all")
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer integer = map.get(nums[i]);
            map.put(nums[i],integer==null?1:map.get(nums[i])+1);
        }
        for(Map.Entry entry:map.entrySet()){
            if((Integer) entry.getValue()>nums.length/2){
                return (int) entry.getKey();
            }
        }
        return 0;
    }
}
