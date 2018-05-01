package String;
/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 * */
@SuppressWarnings("all")
public class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
       if(strs.length==0 || strs==null)
           return "";
       if(strs.length==1)
           return strs[0];
       for(int len=0;len<strs[0].length();len++){
           for(int j=1;j<strs.length;j++){
               //以第一个字符串为准，再从字符串数组里逐个比较 如果长度大于当前string长度 return 或者当前位置的字符不相等 return return的结果为substring 0 len
               if(len>=strs[j].length()||strs[j].charAt(len)!=strs[0].charAt(len))
                   return strs[0].substring(0,len);
           }
       }
       return strs[0];
    }
}
