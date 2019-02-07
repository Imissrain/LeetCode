package String;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 * */
@SuppressWarnings("all")
public class FirstUniqueCharacterinaString {
    /*
    public int indexOf(int ch): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。

    public int indexOf(int ch, int fromIndex): 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。

    int indexOf(String str): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。

    int indexOf(String str, int fromIndex): 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
     */
    /*
     version1:indexOf
     */
    public static int firstUniqChar(String s) {
       for(int i=0;i<s.length();i++){
           char tmp=s.charAt(i);
           if(s.indexOf(tmp,i+1)<0 && s.indexOf(tmp)==i)
               return i;
       }
       return -1;
    }

    /*
      version2:哈希表
     */
    public static int firstUniqChar1(String s) {
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(arr[s.charAt(i)-'a']==1)
                return i;
        }
        return -1;
    }
    public static void main(String[] args){
        String s="lovelive";
        System.out.println(firstUniqChar(s));
    }
}
