package Math;
/**
 * 231. 2的幂
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个整数，写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 * */
@SuppressWarnings("all")
public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if(n==0)
            return false;
        else if(n>Integer.MIN_VALUE&&n<Integer.MAX_VALUE)
            return Integer.toBinaryString(n).indexOf('1')==Integer.toBinaryString(n).lastIndexOf('1');
        else
            return false;
    }
}
