package Array;

import org.junit.Test;

/**
 * 260. 只出现一次的数字 III
 题目描述提示帮助提交记录社区讨论阅读解答
 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。

 示例 :

 输入: [1,2,1,3,2,5]
 输出: [3,5]
 注意：

 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * @author gkyan
 */
@SuppressWarnings("all")
/*
    res=0 首先先逐个异或一遍 这个时候res是那两个数字的异或结果 既然两个数字不同
    那么肯定至少有一位为1 res&=-res 这个操作可以找到最低的那个有效位1 根据这个将原数组分为两部分
    再分别异或 就可以找到两个数字
 */
public class singleNumber_III {
    //先res整个异或一边 得到两个数字的异或值 然后res&-res 找到最低有效位 然后根据最低有效位来将数组分成两部分 分别异或 得到答案
    public int[] singleNumber(int[] nums) {
        int res=0;
        int arr[]=new int[2];
        for(int i=0;i<nums.length;i++){
            res^=nums[i];
        }
        //res返回的是那两个不同的数字的异或值
        res&=-res;//找到的是最后一位的有效位
        for(int i=0;i<nums.length;i++){
            if((nums[i]&res)==0)//按照最低有效位是否为1来将数组分成两部分 然后分别异或
                arr[0]^=nums[i];
            else
                arr[1]^=nums[i];
        }
        return arr;
    }
    @Test
    public void fun(){
        int res=3^5;
        System.out.println(Integer.toBinaryString(6));
        System.out.println(Integer.toBinaryString(-6));
    }
}
