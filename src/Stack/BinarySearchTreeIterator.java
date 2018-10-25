package Stack;

import java.util.Stack;

/**
 * 173. 二叉搜索树迭代器
 题目描述提示帮助提交记录社区讨论阅读解答
 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。

 调用 next() 将返回二叉搜索树中的下一个最小的数。

 注意: next() 和hasNext() 操作的时间复杂度是O(1)，并使用 O(h) 内存，其中 h 是树的高度。
 * @author gkyan
 */

@SuppressWarnings("all")
public class BinarySearchTreeIterator {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //因为是二叉搜索树 先将root的所有left入栈 越往下越小 然后next的时候 从栈中弹出 当弹出节点right不为空时 再将所有此节点的left入栈
    Stack<TreeNode> stack=null;
    public BinarySearchTreeIterator(TreeNode root) {
        stack=new Stack<>();
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode pop = stack.pop();
        if(pop.right!=null){
            TreeNode right=pop.right;
            while (right!=null){
                stack.push(right);
                right=right.left;
            }
        }
        return pop.val;
    }
}
