package DynamicProgromming;

/**
 * 303. 区域和检索 - 数组不可变
 题目描述提示帮助提交记录社区讨论阅读解答
 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。

 示例：

 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()

 sumRange(0, 2) -> 1
 sumRange(2, 5) -> -1
 sumRange(0, 5) -> -3
 * @author gkyan
 */
@SuppressWarnings("all")
public class NumArray {
    //用一个sum数组来保存每一步的和 如果i==0就返回j即可 如果不等于0 由于计算的是i到j区间的值 所以要减去前i-1的和
    int nums[];
    int sum[];
    public NumArray(int[] nums) {
       this.nums=nums;
       sum=new int[nums.length];
       if(nums.length==0) {
           return;
       }
       sum[0]=nums[0];
       for(int i=1;i<nums.length;i++){
           sum[i]=sum[i-1]+sum[i];
       }
    }

    public int sumRange(int i, int j) {
        return i==0?sum[j]:sum[j]-sum[i-1];
    }

    public static void main(String[] args) {
        int nums[]={-2,0,3,-5,2,-1};
        System.out.println(new NumArray(nums).sumRange(0,1));
    }
}
