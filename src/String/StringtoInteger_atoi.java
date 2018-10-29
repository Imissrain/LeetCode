package String;

import org.junit.Test;

/**
 * 字符串转整数（atoi）
 * 实现 atoi，将字符串转为整数。
 *
 * 在找到第一个非空字符之前，需要移除掉字符串中的空格字符。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
 *
 * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
 *
 * 若函数不能执行有效的转换，返回 0。
 *
 * 说明：
 *
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。如果数值超过可表示的范围，则返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 * 示例 1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 *
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 *
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例 5:
 *
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。*/
@SuppressWarnings("all")
public class StringtoInteger_atoi {
    public static int myAtoi(String s) {
        String str = s.trim();//吃空格
        int res=0;
        boolean isPos=true;//设置正负判断标志
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(i==0&&(c=='+'||c=='-')){//第一位进入这个 判断标志
                isPos= c=='+'?true:false;//三目符 +为true -为false
            }else if(c>='0'&&c<='9') {//在数据范围内
                if(res>(Integer.MAX_VALUE-(c-'0'))/10){//判断是否越界时，判断当前res和最大值减去即将要加的值再除10
                    return isPos?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
                res*=10;//因为下面是乘10加c 所以上面最大值减c除10 如果res小于这个玩意 再执行下面的相加操作
                res+=c-'0';
            }else {
                return isPos?res:res*-1;
            }
        }
        return isPos?res:res*-1;
    }

    public static void main(String[] args) {
        String s="42";
        System.out.println(myAtoi(s));
    }
}
