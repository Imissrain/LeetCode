package Tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 145. 二叉树的后序遍历
 题目描述提示帮助提交记录社区讨论阅读解答
 给定一个二叉树，返回它的 后序 遍历。

 示例:

 输入: [1,null,2,3]
 1
 \
 2
 /
 3

 输出: [3,2,1]
 */
@SuppressWarnings("all")
public class BinaryTreePostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //将root存入栈 每次向list的第0位添加元素 相当于revsere 然后将树的左右节点在存入栈
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(stack.isEmpty()==false){
            TreeNode pop = stack.pop();
            res.add(0,pop.val);
            if(pop.left!=null)
                stack.push(pop.left);
            if(pop.right!=null)
                stack.push(pop.right);
        }
        return res;
    }
}
