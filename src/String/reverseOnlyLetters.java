package String;

/**
 * 917. 仅仅反转字母
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 示例 1：

 输入："ab-cd"
 输出："dc-ba"
 示例 2：

 输入："a-bC-dEf-ghIj"
 输出："j-Ih-gfE-dCba"
 示例 3：

 输入："Test1ng-Leet=code-Q!"
 输出："Qedo1ct-eeLg=ntse-T!"


 提示：

 S.length <= 100
 33 <= S[i].ASCIIcode <= 122
 S 中不包含 \ or "
 * @author gkyan
 */
@SuppressWarnings("all")
public class reverseOnlyLetters {
    //周赛A题 acsll码看错了 浪费了好多时间 大概思路 先将有要反转的存下来 然后遍历原字符串符合要求的添加 不符合的按原来位置赋值
    public static String reverseOnlyLetters(String s) {
        if(s.length()==0 || s==null)
            return "";
        StringBuffer sb=new StringBuffer();
        StringBuffer ans=new StringBuffer();
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)>=65&& s.charAt(i)<=90 || s.charAt(i)>=97&&s.charAt(i)<=122){
                    sb.append(s.charAt(i));
            }
        }
        for(int i=0,j=0;i<s.length();){
            if(s.charAt(i)>=65&& s.charAt(i)<=90&&j<sb.length() || s.charAt(i)>=97&&s.charAt(i)<=122&&j<sb.length()){
                ans.append(sb.charAt(j));
                i++;
                j++;
            }else {
                ans.append(s.charAt(i));
                i++;
            }
        }
        return ans.toString();
    }
//
//    输入：
//            "@bq9`h3>>,K+]_h@[#_T"
//    输出：
//            "@Th9`K3>>,h+]_q@b#_T"
//    预期：
//            "@Th9`K3>>,h+]_q@[#_b"
    public static void main(String[] args) {
        String s="@bq9`h3>>,K+]_h@[#_T";
        System.out.println(reverseOnlyLetters(s));
    }
}
