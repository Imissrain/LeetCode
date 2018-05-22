package Math;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;


import java.util.*;

/**
 * 414. 第三大的数
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 * 示例 1:
 *
 * 输入: [3, 2, 1]
 *
 * 输出: 1
 *
 * 解释: 第三大的数是 1.
 * 示例 2:
 *
 * 输入: [1, 2]
 *
 * 输出: 2
 *
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 *
 * 输入: [2, 2, 3, 1]
 *
 * 输出: 1
 *
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。*/
@SuppressWarnings("all")
public class thirdMax {
    public static int thirdMax(int[] nums) {
        //map去重 然后获取keyset keyset存入列表 然后根据长度返回
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer integer = map.get(nums[i]);
            map.put(nums[i],integer==null?1:map.get(nums[i])+1);
            }
            Set<Integer> integers = map.keySet();
            Iterator<Integer> iterator = integers.iterator();
            List<Integer> list=new ArrayList<>();
            while(iterator.hasNext()){
                list.add(iterator.next());
            }
            Collections.sort(list);
            if(list.size()==1)
                return list.get(0);
            else if(list.size()==2)
                return Math.max(list.get(0),list.get(1));
            else
                return list.get(list.size()-3);
    }

    public static void main(String[] args) {
        int nums[]={1,1,2};
        System.out.println(thirdMax(nums));
    }
}
