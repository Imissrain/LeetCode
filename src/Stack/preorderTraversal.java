package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 题目描述提示帮助提交记录社区讨论阅读解答
 给定一个二叉树，返回它的 前序 遍历。

 示例:

 输入: [1,null,2,3]
 1
 \
 2
 /
 3

 输出: [1,2,3]
 */
@SuppressWarnings("all")
public class preorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        //root入栈 while栈不为空 弹出 因为栈先入后出 所以将pop的right，left 不为空的时候push进去
        if(root==null)
            return new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(stack.isEmpty()==false){
            TreeNode pop = stack.pop();
            ans.add(pop.val);
            if(pop.right!=null){
                stack.push(pop.right);
            }
            if(pop.left!=null){
                stack.push(pop.left);
            }
        }
        return ans;
    }
}
