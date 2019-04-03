package Tree;

/**
 * 110. 平衡二叉树
 *
 *
 *
 *
 * 题目描述
 * 评论 (128)
 * 题解
 * 提交记录
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 */
/*
    先判断根节点的左右子树高度差 再去递归判断左子树和右子树 的子树高度差
 */
public class BalancedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        int left=getDepth(root.left);
        int right=getDepth(root.right);
        if(left-right>1 || left-right<-1)
            return false;
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    public int getDepth(TreeNode root){
        if(root==null)
            return 0;
        int left=getDepth(root.left);
        int right=getDepth(root.right);
        return Math.max(left,right)+1;
    }
}
