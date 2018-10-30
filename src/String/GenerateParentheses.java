package String;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 题目描述提示帮助提交记录社区讨论阅读解答
 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

 例如，给出 n = 3，生成结果为：

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
@SuppressWarnings("all")
public class GenerateParentheses {
    //递归咯
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        getAll(new char[n*2],0,res);
        return res;
    }
    public void getAll(char current[],int pos,List<String> result){
        if(pos==current.length){
            if(isvaliad(new String(current))){
                result.add(new String(current));
            }
        }else {
            current[pos]='(';
            getAll(current,pos+1,result);
            current[pos]=')';
            getAll(current,pos+1,result);
        }

    }
    public boolean isvaliad(String str){
        int balance=0;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='(')
                balance++;
            else
                balance--;
            if(balance<0)
                return false;
        }
        return balance==0;
    }

    public static void main(String[] args) {
        int n=3;
        System.out.println(new GenerateParentheses().generateParenthesis(n));
    }
}
