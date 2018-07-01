package Array;

import org.junit.Test;

/**
 * 821. 字符的最短距离
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 *
 * 示例 1:
 *
 * 输入: S = "loveleetcode", C = 'e'
 * 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * 说明:
 *
 * 字符串 S 的长度范围为 [1, 10000]。
 * C 是一个单字符，且保证是字符串 S 里的字符。
 * S 和 C 中的所有字母均为小写字母。
 * */
@SuppressWarnings("all")
public class shortestToChar {
    public static int[] shortestToChar(String S, char C) {
        //正反两次遍历 每次记录C的位置 第一次遍历如果等于C flag记录C的最新下标  arr[i]就等于当前下标减去flag
        //所以flag初始化一个负无穷的值 第二次遍历 flag设置无穷大的值 和当前的arr[i]做比较 取最小
        int arr[]=new int[S.length()];
        int flag=-9999999;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)==C)
                flag=i;
            arr[i]=i-flag;
        }

        flag=9999999;
        for(int i=S.length()-1;i>=0;i--){
            if(S.charAt(i)==C)
                flag=i;
            arr[i]=Math.min(arr[i],flag-i);
        }
        return arr;
    }

    public static void main(String[] args) {
        String s="loveleetcode";;
        for (int i = 0; i <shortestToChar(s,'e').length; i++) {
            System.out.print(shortestToChar(s,'e')[i]);
        }
    }
}
