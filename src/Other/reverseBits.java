package Other;
/**
 * 颠倒二进制位
 * 颠倒给定的32位无符号整数的二进制位。
 *
 * 例如，给定输入 43261596（二进制表示为 00000010100101000001111010011100 ），返回 964176192（二进制表示为 00111001011110000010100101000000）。
 *
 * 问题进阶:
 * 如果多次调用这个函数，你将如何优化它？
 *
 * 相关问题： 颠倒整数
 *
 * 致谢:
 * 特别感谢 @ts 添加此问题并创建所有测试用例。
 * */
@SuppressWarnings("all")
public class reverseBits {
    public static int reverseBits(int n) {
        //傻逼题 过百分之50样例
//        if(n==1)
//            return -2147483648;
//        String s = Integer.toBinaryString(n);
//        char[] chararray = s.toCharArray();
//        long res=0;
//        for(int k=0;k<chararray.length;k++){
//            if(chararray[k]=='1'){
//                res+=(int)Math.pow(2,k+32-chararray.length);
//            }
//        }
//        return (int)res;

        //
        int res=0;
        for(int i=0;i<32;i++){
            res=(res<<1)+(n&1);//res每次左移 加上n最后一位
            n>>=1;//n右移
        }
        return res;
    }

    public static void main(String[] args) {
        int n=1;
        System.out.println(reverseBits(n));

    }
}
