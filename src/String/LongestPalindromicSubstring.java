package String;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
@SuppressWarnings("all")
public class LongestPalindromicSubstring {
    /*
        两重循环暴力 判断每个子串是不是回文 是的话看是不是最长的
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        if(s.length()==1)
            return s;
        String ans= new String();
//        int i=0,j=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String substring = s.substring(i, j+1);
                if(isPalindrome(substring)){
                    if(substring.length()>ans.length()){
                        ans=substring;
                    }
                }
            }
        }
        return ans;
    }
    public boolean isPalindrome(String s){
        if(s.length()==0)
            return true;
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        return s.equals(sb.toString());
    }





    /*
        中心扩展算法 以当前字符为中心 向两边扩展
        注意aba 和abba两种情况
     */
    public String longestPalindrome2(String s){
        if (s == null || s.length() == 0)
            return "";
        if(s.length()==1)
            return s;
        int len=s.length();
        int maxLength=0;
        int start=0;
        //aba   从i-1  i+1往两边走
        for(int i=0;i<len;i++){
            int j=i-1;
            int k=i+1;
            while(j>=0&&k<len&&s.charAt(j)==s.charAt(k)){
                if(k-j+1>maxLength){
                    maxLength=k-j+1;
                    start=j;
                }
                j--;k++;
            }
        }
        //abba   从i i+1 往两边走
        for(int i=0;i<len;i++){
            int j=i;
            int k=i+1;
            while(j>=0&&k<len&&s.charAt(j)==s.charAt(k)){
                if(k-j+1>maxLength){
                    maxLength=k-j+1;
                    start=j;
                }
                j--;k++;
            }
        }
        if(maxLength>0){
            return s.substring(start,start+maxLength);
        }
        return String.valueOf(s.charAt(0));
    }
    public static void main(String[] args) {
        String s="babad";
        System.out.println(new LongestPalindromicSubstring().longestPalindrome2(s));
    }
}
