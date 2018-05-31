package Tree;
/**
 * 617. 合并二叉树
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * */
@SuppressWarnings("all")
public class mergeTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        //递归出口 当节点同时不为空的时候 节点相加 然后 左子树 递归 参数是两棵树的左  右子树 递归 参数是两棵树的右
        if(t1!=null && t2!=null){
            t1.val+=t2.val;
            t1.left=mergeTrees(t1.left,t2.left);
            t2.right=mergeTrees(t1.right,t2.right);
            return t1;
        }else {
            return t1==null?t2:t1;
        }
    }
}
