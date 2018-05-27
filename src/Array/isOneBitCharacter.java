package Array;
/**
 * 717. 1比特与2比特字符
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 *
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 *
 * 示例 1:
 *
 * 输入:
 * bits = [1, 0, 0]
 * 输出: True
 * 解释:
 * 唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
 * 示例 2:
 *
 * 输入:
 * bits = [1, 1, 1, 0]
 * 输出: False
 * 解释:
 * 唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。
 * 注意:
 *
 * 1 <= len(bits) <= 1000.
 * bits[i] 总是0 或 1.
 * */
@SuppressWarnings("all")
public class isOneBitCharacter {
    //最后一位是1返回false  数组长度为1返回true 数组倒数第二位为0返回true 否则循环如果当前位为1 下标加1 如果是最后一位 返回false 如果是0返回true
    public static boolean isOneBitCharacter(int[] bits) {
        if(bits[bits.length-1]==1)
            return false;
        else if(bits.length==1)
            return true;
        else if(bits[bits.length-2]==0)
            return true;
        else {
            for(int i=0;i<bits.length;i++){
                if(bits[i]==1){
                    i++;
                    if(i==bits.length-1)
                        return false;
                    continue;
                }
                if(i==bits.length-1)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int bits[]={1,1,0};
        System.out.println(isOneBitCharacter(bits));
    }
}
