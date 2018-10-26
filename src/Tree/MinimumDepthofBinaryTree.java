package Tree;
/**
 * 111. 二叉树的最小深度
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 * */
@SuppressWarnings("all")
public class MinimumDepthofBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //和最大深度稍有不同，当某个节点的子节点为空时 此时最小 但是那个空节点不属于这棵树 所以当字节点为空是返回无穷大
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        int left=0;
        int right=0;
        if(root.left!=null)
            left=minDepth(root.left);
        else
            left=Integer.MAX_VALUE;

        if(root.right!=null)
            right=minDepth(root.right);
        else
            right=Integer.MAX_VALUE;
        return Math.min(left,right)+1;
    }


    //超时
    public int minDepth1(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        return Math.min((minDepth(root.left)+1)==1?Integer.MAX_VALUE:(minDepth(root.left)+
                1), (minDepth(root.right)+1)==1?Integer.MAX_VALUE:(minDepth(root.right)+1));
    }
}
