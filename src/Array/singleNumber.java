package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * 只出现一次的数字
 * 给定一个整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * */
@SuppressWarnings("all")
public class singleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> entry :map.entrySet()){
            if(entry.getValue()==1)
                return entry.getKey();
        }
        return 0;
    }
}
