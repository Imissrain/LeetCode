package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  存在重复
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数应该返回 true。如果每个元素都不相同，则返回 false。
 * */
@SuppressWarnings("all")
public class ExistDuplicate {
    public boolean containsDuplicate(int[] nums) {
        //传统的HashMap解决
        HashMap<Integer,Integer> map=new HashMap();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>1)
                return true;
        }
        return false;
    }
    //先排序再前后相比
    public boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
