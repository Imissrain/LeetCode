package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
@SuppressWarnings("all")
public class BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //递归转化为迭代 用栈替代 当树不为空或者栈不为空时循环 首先走到 树的最左下端 每一步push当前节点 栈不为空保存然后跳转到右子树
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null || treeNodeStack.isEmpty() == false) {
            while (tmp != null) {
                treeNodeStack.push(tmp);
                tmp = tmp.left;
            }
            if (treeNodeStack.isEmpty() == false) {
                tmp = treeNodeStack.pop();
                integerList.add(tmp.val);
                tmp = tmp.right;
            }
        }
        return integerList;
    }
}
