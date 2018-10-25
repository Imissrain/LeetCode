package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 224. 基本计算器
 题目描述提示帮助提交记录社区讨论阅读解答
 实现一个基本的计算器来计算一个简单的字符串表达式的值。

 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。

 示例 1:

 输入: "1 + 1"
 输出: 2
 示例 2:

 输入: " 2-1 + 2 "
 输出: 3
 示例 3:

 输入: "(1+(4+5+2)-3)+(6+8)"
 输出: 23
 说明：

 你可以假设所给定的表达式都是有效的。
 请不要使用内置的库函数 eval。
 * @author gkyan
 */
@SuppressWarnings("all")
public class BasicCalculator {

    //注意空格的处理和多位数的处理 将处理后的字符串转换为逆波兰式然后计算逆波兰式的值 注意：注意逆波兰式的转换每次添加符号的时候 一直到之前不为(的情况下符号都要弹出 保证运算有序性 此处没有优先级要求
    public static int calculate(String s) {
        if(s.length()==0 || s==null)
            return 0;
        String trim = s.replace(" ","");//处理空格
        return evalRPN(convert(trim));
    }

    //转换成为逆波兰式
    public static String[] convert(String s){
//        Stack<Character> symbolStack=new Stack<>();
        Stack<String> stack=new Stack<>();
        List<String> list=new ArrayList<>();
        String[] split = split(s);
        System.out.println(Arrays.toString(split));
        for(int i=0;i<split.length;i++){
            if(split[i].matches("[-]?\\d+")){//为数字
                list.add(split[i]);
            }else if(split[i].equals("+") || split[i].equals("-")){
                while(stack.isEmpty()==false&&!stack.peek().equals("(")){
                    list.add(stack.pop());
                }
                stack.push(split[i]);
            }else if(split[i].equals("(")){
                stack.push(split[i]);
            }else if(split[i].equals(")")){
                while(!stack.isEmpty()&&(!stack.peek().equals("("))){
                    list.add(stack.pop());
                }
                stack.pop();
            }else if(stack.isEmpty()){
                stack.push(split[i]);
            }
        }
        while (stack.isEmpty()==false){
            list.add(stack.pop());
        }
        String []arr=new String[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        return arr;
    }
    //原字符串中可能含有连续数字 将原始的String分割开
    public static String[] split(String s){
        List<String> list = new ArrayList<>();
        int jump=0;
        for (int i = 0; i < s.length(); i+=jump) {
            int start = 0;
            int end=0;
            jump=1;//跳跃标志
            if (s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '+' || s.charAt(i) == '-'){
                list.add(String.valueOf(s.charAt(i)));
            }else {
                start=i;
                end=i;
                while(end<s.length()&&s.charAt(end)>='0'&&s.charAt(end)<='9'){
                    end++;
                    jump++;
                }
                jump--;
                list.add(s.substring(start,end));
            }
        }
        String []arr=new String[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        return arr;
    }
    //求逆波兰式的值
    public static int evalRPN(String[] tokens) {
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
        String s="2-1+2";
        System.out.println(calculate(s));
    }
}
