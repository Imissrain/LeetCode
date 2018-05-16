package String;
/**
 * 58. 最后一个单词的长度
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 * */
@SuppressWarnings("all")
public class lengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        if(s.length()==0 || s==null)
            return 0;
        String[] split = s.split(" ");
        if(split.length==0)
            return 0;
        return split[split.length-1].length();
    }

    public static void main(String[] args) {
        String s="        ";
        System.out.println(lengthOfLastWord(s));
    }

}
