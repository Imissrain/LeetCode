package String;

import java.util.ArrayList;

/**
 *
 541. 反转字符串 II
 题目描述提示帮助提交记录社区讨论阅读解答
 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。
 如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。

 示例:

 输入: s = "abcdefg", k = 2
 输出: "bacdfeg"
 要求:

 该字符串只包含小写的英文字母。
 给定字符串的长度和 k 在[1, 10000]范围内。
 * */
@SuppressWarnings("all")
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        //小于k直接反转 然后每次截取2k个长度进行操作 操作完成后 字符串每次截断2k长度 当长度小于2k时 反转前k即可
        if(s.length()<k)//小于k直接反转
            return new StringBuffer(s).reverse().toString();
        else if(s.length()<=2*k){//小于等于2k 反转前k加s.length-1
            return new StringBuffer(s.substring(0,k)).reverse().toString()+s.substring(k);
        }else {
            String ans="";
            while(s.length()>2*k){
                ans+=reverseStr(s.substring(0,2*k),k);
                s=s.substring(2*k);
            }
            ans+=reverseStr(s,k);
            return ans;
        }
    }
}
