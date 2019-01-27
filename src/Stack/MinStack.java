package Stack;

import java.util.Stack;

/**
 * 155. 最小栈
 题目描述提示帮助提交记录社区讨论阅读解答
 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

 push(x) -- 将元素 x 推入栈中。
 pop() -- 删除栈顶的元素。
 top() -- 获取栈顶元素。
 getMin() -- 检索栈中的最小元素。
 示例:

 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> 返回 -3.
 minStack.pop();
 minStack.top();      --> 返回 0.
 minStack.getMin();   --> 返回 -2.
 * @author gkyan
 */
@SuppressWarnings("all")
public class MinStack {
    //用一个辅助栈来存储最小值 当push值小于min 更新min 将push值和min分别存入stack和minstack 当push值大于min push进stack min进minstack pop的时候同步pop 并且注意再minstack不为空时更新min值
    /** initialize your data structure here. */
    Stack<Integer> stack=null;
    Stack<Integer> minStack=null;
    public static Integer min=Integer.MAX_VALUE;
    public MinStack() {
        this.stack=new Stack<>();
        this.minStack=new Stack<>();
    }
    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(x);
            minStack.push(x);
            min=x;
        }else {
            if(x<=min){
                minStack.push(x);
                min=x;
                stack.push(x);
            }else {
                minStack.push(min);
                stack.push(x);
            }
        }
    }
    public void pop() {
        stack.pop();
        Integer pop = minStack.pop();
        if(minStack.isEmpty()==false){
            if(pop<minStack.peek())
                min=minStack.peek();
        }else {
            min=pop;
        }

    }

    public int top() {
        return stack.peek();
    }
    public int getMin() {
        /**
         * 辅助栈15w数据超时
         */
//        Stack<Integer> tmp=new Stack<>();
//        while(stack.isEmpty()==false){
//            tmp.push(stack.pop());
//        }
//        int min=Integer.MAX_VALUE;
//        while(tmp.isEmpty()==false){
//            Integer pop = tmp.pop();
//            stack.push(pop);
//            if(pop<min)
//                min=pop;
//        }
//        return min;
        return min;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */