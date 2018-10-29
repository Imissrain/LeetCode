package String;
/**
 * 520. 检测大写字母
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 *
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 *
 * 全部字母都是大写，比如"USA"。
 * 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 * 否则，我们定义这个单词没有正确使用大写字母。
 *
 * 示例 1:
 *
 * 输入: "USA"
 * 输出: True
 * 示例 2:
 *
 * 输入: "FlaG"
 * 输出: False
 * */
@SuppressWarnings("all")
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        //统计大写的个数 如果个数等于字符长度  或者个数等于0  或者个数等于1并且首字符在AZ之间返回true
        if(word.length()==0)
            return false;
        int count=0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)>= 'A'&&word.charAt(i)<='Z'){
                count++;
            }
        }
        if(count==word.length()||word.charAt(0)>='A'&&word.charAt(0)<='Z'&&count==1||count==0)
            return true;
        return false;
    }
}
