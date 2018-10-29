package String;
/**
 *   颠倒整数
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 * */
@SuppressWarnings("all")
public class ReverseBits {
    public int reverse(int x) {
        if(x==0)
            return x;
        else if(x<0)
            return reverseInteger(x)*-1;
        else
            return reverseInteger(x);
    }
    public int reverseInteger(int x){
        long abs = Math.abs(x);
        long res=0;
        while(abs!=0){
            res=res*10+abs%10;
            abs/=10;
        }
        if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE)
            return 0;
        return (int) res;
    }
}
