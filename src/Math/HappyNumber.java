package Math;

/**
 * 202. 快乐数
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例:
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
/*
    恍然大悟 用数组存储0到9各个数字的平方 然后n模10得到个位数字 即为index 相加 设立一个次数 达到多少次就可以视为永远循环 最后判断即可
     */
public class HappyNumber {
    public boolean isHappy(int n) {
        int[] square={0,1,4,9,16,25,36,49,64,81};
        int ans=0;
        int count=0;
        while(ans!=1){
            if(count>1000)
                return false;
            ans=0;
            while(n>0){
                int index=n%10;
                n/=10;
                ans+=square[index];
            }
            n=ans;
            count++;
        }
        return true;
    }

    public static void main(String[] args) {
        int n=2;
        System.out.println(new HappyNumber().isHappy(n));
    }
}
