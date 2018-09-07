package Stack;

/**
 * 856. 括号的分数
 题目描述提示帮助提交记录社区讨论阅读解答
 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：

 () 得 1 分。
 AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 (A) 得 2 * A 分，其中 A 是平衡括号字符串。


 示例 1：

 输入： "()"
 输出： 1
 示例 2：

 输入： "(())"
 输出： 2
 示例 3：

 输入： "()()"
 输出： 2
 示例 4：

 输入： "(()(()))"
 输出： 6


 提示：

 S 是平衡括号字符串，且只含有 ( 和 ) 。
 2 <= S.length <= 50
 * @author gkyan
 */
@SuppressWarnings("all")
public class scoreOfParentheses {
    //只要是()中包含的 我们就要乘2 两层就乘2的平方 以此类推 我们计算(的数量 当下一个不是(时判断和前一个是否构成一个() 然后(数量减1 这部分()的值乘2
    public int scoreOfParentheses(String S) {
        int ans=0;
        int left=0;
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            if(c=='(')
                left++;
            else {
                left--;
                if(S.charAt(i-1)=='('){
                    ans+=1<<left;
                }
            }
        }
        return ans;
    }
}
