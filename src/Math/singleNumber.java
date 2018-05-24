package Math;


import java.util.HashMap;
import java.util.Map;

/**
 * 260. 只出现一次的数字 III
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 * 示例 :
 *
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 注意：
 *
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * */
@SuppressWarnings("all")
public class singleNumber {
    public int[] singleNumber(int[] nums) {
        //hashmap暴力 这里用了Long
        Map<Integer,Long> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Long aLong = map.get(nums[i]);
            map.put(nums[i],aLong==null?1L:map.get(nums[i])+1L);
        }
        int []res=new int[2];
        for(Map.Entry entry:map.entrySet()){
            if(entry.getValue().equals(1L)){
                if (res[0] == 0) {
                    res[0] = (int) entry.getKey();
                } else {
                    res[1] = (int) entry.getKey();
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {

    }
}
