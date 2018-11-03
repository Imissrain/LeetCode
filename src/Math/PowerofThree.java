package Math;
/**
 * 26. 3的幂
 题目描述提示帮助提交记录社区讨论阅读解答
 给定一个整数，写一个函数来判断它是否是 3 的幂次方。

 示例 1:

 输入: 27
 输出: true
 示例 2:

 输入: 0
 输出: false
 示例 3:

 输入: 9
 输出: true
 示例 4:

 输入: 45
 输出: false*/
@SuppressWarnings("all")
public class PowerofThree {

    public boolean isPowerOfThree(int n) {
        //抖机灵
        return ( n>0 &&  1162261467%n==0);

    }
    //常规操作
    public boolean isPowerOfThree1(int n) {
        if (n < 1)
            return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
