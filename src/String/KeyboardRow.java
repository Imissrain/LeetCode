package String;

import java.util.ArrayList;
import java.util.List;

/**
 * 500. Keyboard Row
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 *
 *
 * American keyboard
 *
 *
 * Example 1:
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * Note:
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 * */

public class KeyboardRow {
    public static String[] findWords(String[] words) {
        if(words.length == 0)
            return words;
        //将键盘三行先存起来  逐个遍历words 满足一行设置为1 当三个值加起来为1 放入容器 否则继续循环
        String s1="QWERTYUIOPqwertyuiop";
        String s2="ASDFGHJKLasdfghjkl";
        String s3="ZXCVBNMzxcvbnm";
        List<String> res=new ArrayList<>();
        int flag_s1=0;
        int flag_s2=0;
        int flag_s3=0;
        for(int i=0;i<words.length;i++){
            flag_s1=0;flag_s2=0;flag_s3=0;
            for(int j=0;j<words[i].length();j++)
                if(s1.indexOf(words[i].charAt(j))>0)
                    flag_s1=1;
            for(int j=0;j<words[i].length();j++)
                if(s2.indexOf(words[i].charAt(j))>0)
                    flag_s2=1;
            for(int j=0;j<words[i].length();j++)
                if(s3.indexOf(words[i].charAt(j))>0)
                    flag_s3=1;
            if(flag_s1+flag_s2+flag_s3==1) res.add(words[i]);
        }
        String[] ans=new String[res.size()];
        for(int i=0;i<res.size();i++)
            ans[i]=res.get(i);
        return ans;
    }

    public static void main(String[] args) {
        String [] s={"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(findWords(s));
    }
}
