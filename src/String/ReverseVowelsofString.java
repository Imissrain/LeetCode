package String;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 345. 反转字符串中的元音字母
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 *
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 */
@SuppressWarnings("all")
public class ReverseVowelsofString {
    /*
    对撞指针 从前到后 从后往前 找元音 找到后swap
     */
    public String reverseVowels(String s) {
        if(s==null || s.length()==0)
            return "";
        char[] chars = s.toCharArray();
        int i=0,j=s.length()-1;
        while(i<j){
            if(chars[i]=='a'||chars[i]=='A'||chars[i]=='e'||chars[i]=='E'||
                    chars[i]=='i'||chars[i]=='I'||chars[i]=='o'||chars[i]=='O'||chars[i]=='u'||chars[i]=='U'){
                if(chars[j]=='a'||chars[j]=='A'||chars[j]=='e'||chars[j]=='E'||
                        chars[j]=='i'||chars[j]=='I'||chars[j]=='o'||chars[j]=='O'||chars[j]=='u'||chars[j]=='U'){
                    swap(chars,i,j);
                    i++;j--;
                }else {
                    j--;
                }

            }else {
                i++;
            }

        }

        return new String(chars);
    }

    private void swap(char[] chars,int i,int j){
        char tmp=chars[i];
        chars[i]=chars[j];
        chars[j]=tmp;
    }

    public static void main(String[] args) {
        String s="leetcode";
        System.out.println(new ReverseVowelsofString().reverseVowels(s));
    }
}
