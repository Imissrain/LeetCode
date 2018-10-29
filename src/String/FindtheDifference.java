package String;

import java.util.ArrayList;

/**
 * 389. 找不同
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *
 *
 * 示例:
 *
 * 输入：
 * s = "abcd"
 * t = "abcde"
 *
 * 输出：
 * e
 *
 * 解释：
 * 'e' 是那个被添加的字母。
 * */
@SuppressWarnings("all")
public class FindtheDifference {
    //桶思想 两个数组实现 找到值不等的下标
    public char findTheDifference(String s, String t) {
        int arr1[]=new int[26];
        int arr2[]=new int[26];
        for(int i=0;i<s.length();i++){
            arr1[s.charAt(i)-32-'A']++;
        }
        for(int i=0;i<t.length();i++){
            arr2[t.charAt(i)-32-'A']++;
        }
        int index=0;
        for(int i=0;i<arr2.length;i++){
            if(arr1[i]!=arr2[i]){
                index=i;
                break;
            }
        }
        return (char) ('A'+index+32);
    }
}
