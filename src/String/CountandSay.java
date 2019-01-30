package String;

import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;

/** 38. 报数
 题目描述提示帮助提交记录社区讨论阅读解答
 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 被读作  "one 1"  ("一个一") , 即 11。
 11 被读作 "two 1s" ("两个一"）, 即 21。
 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。

 注意：整数顺序将表示为一个字符串。



 示例 1:

 输入: 1
 输出: "1"
 示例 2:

 输入: 4
 输出: "1211"
 * */
/*
    读明白题目的意思 本质就是数数字的个数然后再输出数字 定义一个count来数数 然后第n步依赖第n-1步 递归即可 递归基为n==1的时候返回1
 */
@SuppressWarnings("all")
public class CountandSay {
    public String countAndSay(int n) {
        if(n<0)
            return "";
        if(n==1)
            return "1";
        String origin=countAndSay(n-1);
        StringBuilder stringBuilder=new StringBuilder();
        int len=origin.length();
        int count=1;
        for(int i=0;i<len;i++){
            if(i==len-1){
                stringBuilder.append(count);
                stringBuilder.append(origin.charAt(i));
                break;
            }
            if(origin.charAt(i)==origin.charAt(i+1)){
                count++;
                continue;
            }else {
                stringBuilder.append(count);
                stringBuilder.append(origin.charAt(i));
                count=1;
            }
        }
        return stringBuilder.toString();
    }
}
