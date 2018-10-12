package Greedy;

import java.util.Arrays;

/**
 * 402. 移掉K位数字
 题目描述提示帮助提交记录社区讨论阅读解答
 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。

 注意:

 num 的长度小于 10002 且 ≥ k。
 num 不会包含任何前导零。
 示例 1 :

 输入: num = "1432219", k = 3
 输出: "1219"
 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 示例 2 :

 输入: num = "10200", k = 1
 输出: "200"
 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 示例 3 :

 输入: num = "10", k = 2
 输出: "0"
 解释: 从原数字移除所有的数字，剩余为空就是0。
 * @author gkyan
 */
@SuppressWarnings("all")
public class removeKdigits {
    public static String removeKdigits(String num, int k) {
        //每次从头开始寻找下降点 然后从这里开始删除 注意0的判断和最后输出的时候要注意字符长度应该是数组长度减去删除的k
        if(num.length()==k)
            return "0";
        char[] chars = num.toCharArray();
        int index=k;
        while(k>0){
            int i=0;//从头开始寻找下降点
            while (i+1<chars.length&&chars[i]<=chars[i+1]){//寻找下降点 判断访问合法 注意i+1
                i++;
            }
            for(int j=i;j<chars.length-1;j++){//删除
                chars[j]=chars[j+1];
            }
            k--;
        }
        int start=0;
        for(int i=0;i<chars.length;i++){//0开头
            if(chars[i]!='0'){
                start=i;
                break;
            }
        }
        boolean flag=true;//全是0
        for(int i=0;i<chars.length;i++){
            if(chars[i]!='0'){
                flag=false;
                break;
            }
        }
        if(flag)
            return "0";
        StringBuffer sb=new StringBuffer();
        for(int i=start;i<num.length()-index;i++){
            sb.append(chars[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s="100";
        int k=1;
        System.out.println(removeKdigits(s,k));

    }
}
