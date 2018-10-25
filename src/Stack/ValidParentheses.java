package Stack;

import java.util.Stack;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 * */
@SuppressWarnings("all")
public class ValidParentheses {

//switch遇到左半部分压栈 遇到右半部分 pop比较 如果栈为空或者不相等 false 否则pop 继续比较 注意栈判空要放在前面 ||这东西会短路
    public static boolean isValid(String s) {
        if(s.length()==0)
            return true;
        if(s.length()%2!=0)
            return false;
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case '(':stack.push(s.charAt(i));break;
                case ')':
                    if(stack.isEmpty()||stack.peek()!='(')//注意这里 判空写前面
                        return false;
                    stack.pop();
                    break;

                case '[':stack.push(s.charAt(i));break;
                case ']':
                    if(stack.isEmpty()||stack.peek()!='[')
                        return false;
                    stack.pop();
                    break;

                case '{':stack.push(s.charAt(i));break;
                case '}':
                if(stack.isEmpty()||stack.peek()!='{')
                    return false;
                stack.pop();
                break;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid1(String s){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char top=s.charAt(i);
            if(top=='('||top=='['||top=='{')
                stack.push(top);
            else {
                if(stack.empty())
                    return false;
                char topp=stack.pop();
                if(top==')'&&topp!='(')
                    return false;
                if(top==']'&&topp!='[')
                    return false;
                if(top=='}'&&topp!='{')
                    return false;
                }
            }
            return stack.isEmpty();
        }

    public static void main(String[] args) {
        System.out.println(ValidParentheses.class.getClassLoader());
    }
}
