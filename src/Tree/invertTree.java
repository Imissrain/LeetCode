package Tree;
/**
 * 226. 翻转二叉树
 * 题目描述提示帮助提交记录社区讨论阅读解答
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * */
@SuppressWarnings("all")
public class invertTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //左右子树同不为空 交换左右子树 然后递归的交换左子树和右子树 最后将root返回
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        if(root.left==null && root.right==null)
            return root;
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
