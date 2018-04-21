package DynamicProgromming;
/**
 *   爬楼梯
 * 假设你正在爬楼梯。需要 n 步你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 步 + 1 步
 * 2.  2 步
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 步 + 1 步 + 1 步
 * 2.  1 步 + 2 步
 * 3.  2 步 + 1 步*/
@SuppressWarnings("all")
public class ClimbingStairs {
    public int climbStairs(int n) {
        int res[]=new int[10000];
        res[1]=1;
        res[2]=2;
        res[3]=3;
        for(int i=4;i<=n;i++){
            res[i]=res[i-1]+res[i-2];//记忆化数组 递归爆栈
        }
        return res[n];
    }
}
