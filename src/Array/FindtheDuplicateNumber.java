package Array;

import java.util.HashMap;
import java.util.Map;
/**
 * 287. 寻找重复数
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * */
@SuppressWarnings("all")
public class FindtheDuplicateNumber {
    //hashmap暴力..
    public int findDuplicate1(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap();
        for(int i=0;i<nums.length;i++){
            Integer val=map.get(nums[i]);
            map.put(nums[i],val==null?1:map.get(nums[i])+1);
        }
        for(Map.Entry entry :map.entrySet()){
            if(!entry.getValue().equals(1)){
                return (int) entry.getKey();
            }
        }
        return 0;
    }

    //二分
    public static int findDuplicate2(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            int cnt=0;
            for(Integer integer:nums){
                if(integer<=mid)
                    cnt++;
            }
            if(cnt<=mid)
                low=mid+1;
            else
                high=mid;
        }
        return low;
    }

    //双指针
    public static int findDuplicate3(int[] nums) {
        int slow = 0, fast = 0, t = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }
        while (true) {
            slow = nums[slow];
            t = nums[t];
            if (slow == t) break;
        }
        return slow;
    }
    public static void main(String[] args) {
        int []arr={3,1,3,4,2};
        System.out.println(findDuplicate3(arr));
    }
}
