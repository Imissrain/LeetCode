package String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 *
 * 例如，
 * s = "anagram"，t = "nagaram"，返回 true
 * s = "rat"，t = "car"，返回 false
 *
 * 注意:
 * 假定字符串只包含小写字母。
 *
 * 提升难度:
 * 输入的字符串包含 unicode 字符怎么办？你能能否调整你的解法来适应这种情况？
 * */
@SuppressWarnings("all")
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        boolean flag=true;
        char[] arrays = s.toCharArray();
        char[] arrayt = t.toCharArray();
        Arrays.sort(arrays);
        Arrays.sort(arrayt);
        for(int i=0;i<arrays.length;i++){
            if(arrays[i]!=arrayt[i])
                return false;
        }
        return true;
    }
    //榜首的方法总是很机智  类似桶排序的思想
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] table = new int[26];
        for (char str : s.toCharArray()) {
            table[str - 'a']++;
        }
        //遍历tstring 如果有某个位置小于0 就说明他俩不是同构的

        for (char str : t.toCharArray()) {
            if (--table[str - 'a'] < 0) return false;
        }
        return true;
    }

}
