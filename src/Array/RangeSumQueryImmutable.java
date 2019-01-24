package Array;

/**
 * 303. 区域和检索 - 数组不可变
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * <p>
 * 示例：
 * <p>
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 */
/*
    看到区间求值我们很容易想到线段树，这道题因为数组元素是不可变的 采用动态规划也可以
    声明一个比原数组长1的sum数组 sum[i]的值是原数组0到nums[i]的总和 初始化时为O(n) 区间计算操作为O(1)
 */
public class RangeSumQueryImmutable {
    class NumArray {
        private int[] sum;
        public NumArray(int[] nums) {
            sum=new int[nums.length+1];
            sum[0]=0;
            for(int i=1;i<sum.length;i++){
                sum[i]=nums[i-1]+sum[i-1];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j+1]-sum[i];
        }
    }
}
