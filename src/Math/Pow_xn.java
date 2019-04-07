package Math;

/**
 * 50. Pow(x, n)
 *
 *
 *
 *
 * 题目描述
 * 评论 (122)
 * 题解
 * 提交记录
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
/*
递归乘法快速幂
 */
public class Pow_xn {
    public double myPow(double x, int n) {
        if(n>0)
            return pow(x,n);
        else {
            if(n==Integer.MIN_VALUE){
                return 1.0/(pow(x,-(Integer.MIN_VALUE+1))*x);
            }
            return 1.0/(pow(x,-n));
        }
    }

    public double pow(double x,int n){
        if(n==0)
            return 1;
        double half=pow(x,n>>1);
        double res=half*half;
        if((n&1)!=0){
            res=res*x;
        }
        return res;
    }


    /*
    *
    * */
//    private static long pow(long a, long n, long mod){
//        if(n==0)
//            return 1;
//        long half=pow(a,n>>1,mod);
//        long res=(half*half)%mod;
//        if((n&1)!=0){
//            res=(res*a)%mod;
//        }
//        return res;
//    }
}
