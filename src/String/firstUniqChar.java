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
public class firstUniqChar {
    public static int firstUniqChar(String s) {
       for(int i=0;i<s.length();i++){
           char tmp=s.charAt(i);
           if(s.indexOf(tmp,i+1)<0 && s.indexOf(tmp)==i)
               return i;
       }
       return -1;
    }
    public static void main(String[] args){
        String s="lovelive";
        System.out.println(firstUniqChar(s));
    }
}
