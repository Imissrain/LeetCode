package Math;
/**
 * 67. 二进制求和
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * */
@SuppressWarnings("all")
public class AddBinary {
    public static String addBinary(String a, String b) {
        //直接专成数字会溢出 这里用stringbulider来模拟相加 carry来模拟进位  如果最后carry不为0 再给首部填充1
        StringBuilder stringBuilder=new StringBuilder();
        int carry=0;
        int i=a.length()-1;
        int j=b.length()-1;
        while(i>=0 || j>=0){
            //carry是进位
            int m=i>=0?a.charAt(i)-'0':0;
            int n=j>=0?b.charAt(j)-'0':0;
            int sum=m+n+carry;
            carry=sum/2;
            stringBuilder.insert(0,String.valueOf(sum%2));
            i--;
            j--;
        }
        if(carry!=0)
            stringBuilder.insert(0,1);
        return stringBuilder.toString();
    }


    //暴力会溢出 leetcode的样例真的很严格
    public static String addBinary1(String a, String b) {
        int a_ = conventNum(a);
        int b_ = conventNum(b);
        return Integer.toBinaryString(a_+b_);
    }

    public static int conventNum(String s){
        int count=0;
        int res=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='1'){
                res+=Math.pow(2,count);
            }
            count++;
        }
        return res;
    }
    public static void main(String[] args) {
        String a="10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b="110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        System.out.println(addBinary(a,b));
    }
}
