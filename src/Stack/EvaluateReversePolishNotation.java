package Stack;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 题目描述提示帮助提交记录社区讨论阅读解答
 根据逆波兰表示法，求表达式的值。

 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。

 说明：

 整数除法只保留整数部分。
 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 示例 1：

 输入: ["2", "1", "+", "3", "*"]
 输出: 9
 解释: ((2 + 1) * 3) = 9
 示例 2：

 输入: ["4", "13", "5", "/", "+"]
 输出: 6
 解释: (4 + (13 / 5)) = 6
 示例 3：

 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 输出: 22
 解释:
 ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 = ((10 * (6 / (12 * -11))) + 17) + 5
 = ((10 * (6 / -132)) + 17) + 5
 = ((10 * 0) + 17) + 5
 = (0 + 17) + 5
 = 17 + 5
 = 22
 * @author gkyan
 */
@SuppressWarnings("all")
public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        //操作数栈和运算符栈分别来存储操作数和运算符 操作数栈每次pop两个 运算符每次pop一个 当操作数栈元素大于等于2 操作数栈元素等于1时进行运算 结果压入操作数栈
        if(tokens.length==1)
            return Integer.valueOf(tokens[0]);
        Stack<Integer> numberStack=new Stack<>();
        Stack<String> symbolStack=new Stack<>();
        int result=0;
        for(String v:tokens){
            if(v.equals("+") || v.equals("-") || v.equals("*")||v.equals("/")){//处理运算符
                symbolStack.push(v);
            }else {
                if(v.startsWith("-")){//处理负数
                    String tmp = v.substring(1, v.length());
                    numberStack.push(Integer.valueOf(tmp)*-1);
                }else {
                    numberStack.push(Integer.valueOf(v));
                }
            }
            if(numberStack.size()>=2&&symbolStack.size()==1){
                int right=numberStack.pop();
                int left=numberStack.pop();
                String symbol=symbolStack.pop();
                if(symbol.equals("+")){
                    result=left+right;
                }else if(symbol.equals("-")){
                    result=left-right;
                }else if(symbol.equals("*")){
                    result=left*right;
                }else if(symbol.equals("/")){
                    result=left/right;
                }
                numberStack.push(result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String []arr={"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(arr));
    }
}
