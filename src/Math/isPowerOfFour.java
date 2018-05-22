package Math;
/**
 * 342. 4的幂
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个整数 (32位有符整数型)，请写出一个函数来检验它是否是4的幂。
 *
 * 示例:
 * 当 num = 16 时 ，返回 true 。 当 num = 5时，返回 false。
 * */
@SuppressWarnings("all")
public class isPowerOfFour {
    public static boolean isPowerOfFour(int num) {
        //如果一个数减1是3的倍数同时还是2的幂 则这个数字是4的幂
        if(num<0)
            return false;
       return (num-1)%3==0&&Integer.toBinaryString(num).indexOf('1')==Integer.toBinaryString(num).lastIndexOf('1');
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(2));
    }
}
