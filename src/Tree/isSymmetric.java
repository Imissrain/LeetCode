package Tree;
/**
 *
 * 101. 对称二叉树
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3*/
@SuppressWarnings("all")
public class isSymmetric {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //递归解决 如果root为空 返回true
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return checkNode(root.left,root.right);
    }
    public boolean checkNode(TreeNode left,TreeNode right){
        //左右都为空返回true
        if(left ==null && right==null)
            return true;
        //一边不为空 返回false
        if(left==null || right==null)
            return false;

        //否则 比较左子树的左子树和右子树的右子树 左子树的右子树和右子树的左子树
        if(left.val==right.val){
            return checkNode(left.left,right.right)&&checkNode(left.right,right.left);
        }else {
            return false;
        }
    }
}
