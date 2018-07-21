package Math;
/**
 * 171. Excel表列序号
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: "ZY"
 * 输出: 701
 * */
@SuppressWarnings("all")
public class titleToNumber {
    public static int titleToNumber(String s) {
        //找规律即可
        int val[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        if(s.length()==1)
            return val[s.charAt(0)-'A'];
        int sum=0;
        int len=s.length()-1;
        for(int i=0;i<s.length();i++){
            sum+=(s.charAt(i)-'A'+1)*Math.pow(26,len);
            len--;
        }
        return sum;
    }

    public static void main(String[] args) {
        String s="A";
        System.out.println(titleToNumber(s));
    }
}
