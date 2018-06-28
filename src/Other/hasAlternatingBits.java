package Other;
/**
 * 693. 交替位二进制数
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 *
 * 示例 1:
 *
 * 输入: 5
 * 输出: True
 * 解释:
 * 5的二进制数是: 101
 * 示例 2:
 *
 * 输入: 7
 * 输出: False
 * 解释:
 * 7的二进制数是: 111
 * 示例 3:
 *
 * 输入: 11
 * 输出: False
 * 解释:
 * 11的二进制数是: 1011
 *  示例 4:
 *
 * 输入: 10
 * 输出: True
 * 解释:
 * 10的二进制数是: 1010
 * */
@SuppressWarnings("all")
public class hasAlternatingBits {
    //转成二进制字符串然后前后相比
    public static boolean hasAlternatingBits(int n) {
        String binaryString = Integer.toBinaryString(n);
        boolean flag=true;
        for(int i=0;i<binaryString.length()-1;i++){
            if(binaryString.charAt(i)==binaryString.charAt(i+1)){
                flag=false;
                break;
            }
        }
        return flag;
    }
    //位运算
    public static boolean hasAlternatingBits1(int n) {
        int before=n%2;
        while(n>0){
            n/=2;
            int cur=n%2;
            if(cur==before)
                return false;
            before=cur;
        }
        return true;
    }


    public static void main(String[] args) {
        int n=5;
        System.out.println(hasAlternatingBits1(n));
    }
}
