package Array;

import java.util.HashSet;

/**
 * 349. 两个数组的交集
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定两个数组，写一个函数来计算它们的交集。
 *
 * 例子:
 *
 *  给定 num1= [1, 2, 2, 1], nums2 = [2, 2], 返回 [2].
 *
 * 提示:
 *
 * 每个在结果中的元素必定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * */
@SuppressWarnings("all")
public class IntersectionoTwoArrays {
    //考虑到HashSet可以去重 先存入set1 去重之后 看是否存在nums2的值再存入set2 转成数组返回
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> num1=new HashSet<>();
        HashSet<Integer> num2=new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            num1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            if(num1.contains(nums2[i])){
                num2.add(nums2[i]);
            }
        }

        int res[]=new int[num2.size()];
        int index=0;
        for(Integer integer:num2){
            res[index++]=integer;
        }
        return res;
    }
}
