package Other;
/**
 *  位1的个数
 * 编写一个函数，输入是一个无符号整数，返回的是它所有 位1 的个数（也被称为汉明重量）。
 *
 * 例如，32位整数 '11' 的二进制表示为 00000000000000000000000000001011，所以函数返回3。
 *
 * 特别鸣谢:
 * @ts 添加此问题并创建所有测试用例。
 * */
@SuppressWarnings("all")
public class hammingWeight {
    public int hammingWeight(int n) {
        //Integer.bitCount(n)
//        return Integer.bitCount(n);


        //Integer.toBinaryString(n).replaceAll("0","").length()
//        return Integer.toBinaryString(n).replaceAll("0","").length();


//        int count=0;
//        while(n!=0){
//            count++;
//            n&=(n-1);
//        }
//        return count;

        int count=0;
        while(n!=0){
            if((n&1)!=0)
                count++;
            n>>=1;
        }
        return count;
    }
}
