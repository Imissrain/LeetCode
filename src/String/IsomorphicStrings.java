package String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 205. 同构字符串
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 */
@SuppressWarnings("all")
/*
    hashmap用来存储一一映射 set用来存储已经映射过的键的集合 如果值已经被映射过那么就返回false
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.length() == 0 && t.length() == 0)
            return true;
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char chars = s.charAt(i);
            char chart = t.charAt(i);
            if (!map.containsKey(chars)) {
                if (set.contains(chart)) {
                    return false;
                } else {
                    map.put(chars, chart);
                    set.add(chart);
                }
            } else {
                if (map.get(chars) != chart) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsomorphicStrings().isIsomorphic("ab", "aa"));
    }
}
