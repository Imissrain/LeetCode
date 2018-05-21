package Math;
/**
 * 258. 各位相加
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 *
 * 示例:
 *
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * */
@SuppressWarnings("all")
public class addDigits {
    public int addDigits(int num) {
        if(num<9)
            return num;
        int res = getSum(num);
        while(res>=10){
            res=getSum(res);
        }
        return res;
    }
    public int getSum(int num){
        int res=0;
        while(num>0){
            res+=num%10;
            num/=10;
        }
        return res;
    }
}
