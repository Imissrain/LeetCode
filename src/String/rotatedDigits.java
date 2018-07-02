package String;
/**
 * 788. 旋转数字
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 *
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 *
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 *
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释:
 * 在[1, 10]中有四个好数： 2, 5, 6, 9。
 * 注意 1 和 10 不是好数, 因为他们在旋转之后不变。
 * 注意:
 *
 * N 的取值范围是 [1, 10000]。
 * */
@SuppressWarnings("all")
public class rotatedDigits {
    //从1开始 3 4 7 不成立都返回false 0 1 8跳出switch看下一位 否则返回true
    public int rotatedDigits(int N) {
        int ans=0;
        for(int i=1;i<=N;i++){
            ans+=isViliad(i)?1:0;
        }
        return ans;
    }
    public boolean isViliad(int n){
        boolean flag=false;
        while(n>0){
            switch (n%10){
                case 3:
                    case 4:
                        case 7:
                            return false;
                case 0:
                    case 1:
                        case 8:
                            break;
                default:
                    flag=true;
            }
            n/=10;
        }
        return flag;
    }
}
