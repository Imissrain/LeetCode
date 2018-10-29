package String;

import java.util.Stack;

/**
 * 验证回文字符串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false、
 * */
@SuppressWarnings("all")
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if(s==null ||s.length()==0)
            return true;
        boolean flag=true;
        String lowerCase = s.toLowerCase();//先转换成小写
        Stack<Character> stack=new Stack<>();//初始化栈
        for(int i=0;i<lowerCase.length();i++){
            if(lowerCase.charAt(i)>='a'&&lowerCase.charAt(i)<='z' || lowerCase.charAt(i)<='9'&&lowerCase.charAt(i)>='0'){
                stack.push(lowerCase.charAt(i));//小写和数字入栈
            }
        }
        for (int i=0;i<lowerCase.length();i++){
            if(lowerCase.charAt(i)>='a'&&lowerCase.charAt(i)<='z' || lowerCase.charAt(i)<='9'&&lowerCase.charAt(i)>='0'){
                if(stack.pop()!=lowerCase.charAt(i)){//出栈比较 不相等flase return
                    flag=false;
                    break;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        String s="race a car";
        System.out.println(isPalindrome(s));
    }
}
