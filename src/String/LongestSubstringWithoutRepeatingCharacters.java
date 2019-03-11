package String;

import java.util.HashSet;

/**
 * 3. 无重复字符的最长子串
 * 提交记录
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
/*
    Hashset滑动窗口  set中没有就加进去  取窗口长度和max更新最大值 set中有就remove掉窗口左边的
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        int i=0,j=0;
        int n=s.length();
        HashSet<Character> hashSet=new HashSet<>();
        while(i<n&&j<n){
            if(!hashSet.contains(s.charAt(j))){
                hashSet.add(s.charAt(j++));
                max=Math.max(max,j-i);
            }else {
                hashSet.remove(s.charAt(i++));
            }
        }
        return max;
    }
}
