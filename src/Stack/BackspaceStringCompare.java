package Stack;

import java.util.Stack;

/**
 * 844. 比较含退格的字符串
 题目描述提示帮助提交记录社区讨论阅读解答
 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。



 示例 1：

 输入：S = "ab#c", T = "ad#c"
 输出：true
 解释：S 和 T 都会变成 “ac”。
 示例 2：

 输入：S = "ab##", T = "c#d#"
 输出：true
 解释：S 和 T 都会变成 “”。
 示例 3：

 输入：S = "a##c", T = "#a#c"
 输出：true
 解释：S 和 T 都会变成 “c”。
 示例 4：

 输入：S = "a#c", T = "b"
 输出：false
 解释：S 会变成 “c”，但 T 仍然是 “b”。


 提示：

 1 <= S.length <= 200
 1 <= T.length <= 200
 S 和 T 只含有小写字母以及字符 '#'。
 * @author gkyan
 */
@SuppressWarnings("all")
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        //两个栈模拟 碰到#就pop 否则push 细节：pop的时候注意栈是否为空 push的时候注意判断是否是#
        Stack<Character> left=new Stack<>();
        Stack<Character> right=new Stack<>();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='#'&&!left.isEmpty()){
                left.pop();
            }else {
                if(S.charAt(i)!='#')
                    left.push(S.charAt(i));
            }
        }
        for(int i=0;i<T.length();i++){
            if(T.charAt(i)=='#'&&!right.isEmpty()){
                right.pop();
            }else {
                if(T.charAt(i)!='#')
                    right.push(T.charAt(i));
            }
        }
        if(left.size()!=right.size())
            return false;
        for(int i=0;i<left.size();i++){
            if(left.pop()!=right.pop())
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String S="y#fo##f";
        String T="y#f#o##f";
        System.out.println(new Stack.BackspaceStringCompare().backspaceCompare(S,T));
    }
}
