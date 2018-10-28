package Other;
/**
 * 371. 两整数之和
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 不使用运算符 + 和-，计算两整数a 、b之和。
 *
 * 示例：
 * 若 a = 1 ，b = 2，返回 3。*/
@SuppressWarnings("all")
public class SumofTwoIntegers {
    //异或是不进位的加法 只有两个对应位置都是1的时候才会进位  我们用&来模拟进位 因为要进位 所以<<1 然后重复处理进位问题
    public static int getSum(int a, int b) {
        if(b==0)
            return a;
        while(b!=0){
            int carry=a&b;
            a=a^b;
            b=carry<<1;
        }
        return a;
    }


    public static void main(String[] args) {
        int a=2;
        int b=3;
        System.out.println(getSum(a,b));
    }
}
